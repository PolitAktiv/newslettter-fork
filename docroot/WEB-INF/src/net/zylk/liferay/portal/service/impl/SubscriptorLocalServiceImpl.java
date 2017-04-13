package net.zylk.liferay.portal.service.impl;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import net.zylk.liferay.portal.DuplicateSubscriptorException;
import net.zylk.liferay.portal.EmptyFieldException;
import net.zylk.liferay.portal.ImportException;
import net.zylk.liferay.portal.NoSuchSubscriptorException;
import net.zylk.liferay.portal.model.Subscriptor;
import net.zylk.liferay.portal.model.SubscriptorCategory;
import net.zylk.liferay.portal.service.base.SubscriptorLocalServiceBaseImpl;
import net.zylk.liferay.portal.service.persistence.SubscriptorFinderUtil;
import net.zylk.liferay.portal.util.EmailUtil;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the subscriptor local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link net.zylk.liferay.portal.service.SubscriptorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author zylk.net
 * @see net.zylk.liferay.portal.service.base.SubscriptorLocalServiceBaseImpl
 * @see net.zylk.liferay.portal.service.SubscriptorLocalServiceUtil
 */
public class SubscriptorLocalServiceImpl extends SubscriptorLocalServiceBaseImpl {
	
	public static Log _log = LogFactoryUtil.getLog(SubscriptorLocalServiceImpl.class);


	public Subscriptor addSubscriptor(long companyId, long groupId, String name, String surname, String email, String languageId, long[] categoryIds, boolean selfSubscribe) throws SystemException, PortalException {

		validateNewSubscritor(companyId, groupId, name, surname, email);
		
        long subscriptorId = counterLocalService.increment(Subscriptor.class.getName());
        Subscriptor subscriptor = subscriptorPersistence.create(subscriptorId);
        subscriptor.setCompanyId(companyId);
        subscriptor.setGroupId(groupId);
        subscriptor.setName(name);
        subscriptor.setSurname(surname);
        subscriptor.setEmail(email);
        subscriptor.setLanguageId(languageId);
        subscriptor.setSelfSubscribe(selfSubscribe);
        subscriptor = subscriptorPersistence.update(subscriptor, false);
        
        subscriptorCategoryLocalService.editSubscriptorCategory(subscriptorId, categoryIds);
        
        return subscriptor;
	}
	
	public Subscriptor editSubscriptor(long subscriptorId, String name, String surname, String email, String languageId) throws SystemException, PortalException {

		Subscriptor subscriptor = subscriptorPersistence.findByPrimaryKey(subscriptorId);
		
		validateEditSubscritor(subscriptor, name, surname, email);
		
        subscriptor.setName(name);
        subscriptor.setSurname(surname);
        subscriptor.setEmail(email);
        subscriptor.setLanguageId(languageId);
        subscriptor = subscriptorPersistence.update(subscriptor, false);
        
        return subscriptor;
	}
	
	public Subscriptor editSubscriptor(long subscriptorId, String name, String surname, String email, String languageId, long[] categoryIds) throws SystemException, PortalException {

		Subscriptor subscriptor = editSubscriptor(subscriptorId, name, surname, email, languageId);
        
		subscriptorCategoryLocalService.editSubscriptorCategory(subscriptor.getSubscriptorId(), categoryIds);
        
        return subscriptor;
	}
	
	public void importSubscriptor(long companyId, long groupId, InputStream csvFile, long[] categoryIds) throws SystemException, PortalException {

		try {
			Reader reader = new InputStreamReader(csvFile);
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(reader);
			
			for (CSVRecord record : records) {
			
				String recordData = "line=" + record.getRecordNumber();
				
				String name = null;
				try {
					name = record.get(0);
					recordData += ", name=" + name;
				} catch (ArrayIndexOutOfBoundsException e) {
					throw new ImportException("name column not found" + " (" + recordData + ")", e);
				}
				
				String surname = null;
				try {
					surname = record.get(1);
					recordData += ", surname=" + surname;
				} catch (ArrayIndexOutOfBoundsException e) {
					throw new ImportException("surname column not found" + " (" + recordData + ")", e);
				}
				
				String email = null;
				try {
					email = record.get(2);
					recordData += ", email=" + email;
				} catch (ArrayIndexOutOfBoundsException e) {
					throw new ImportException("email column not found" + " (" + recordData + ")", e);
				}
				
				String lang = null;
				try {
					lang = record.get(3);
					recordData += ", language=" + lang;
				} catch (ArrayIndexOutOfBoundsException e) {
					throw new ImportException("language column not found" + " (" + recordData + ")", e);
				}
				
				_log.info(recordData);
	
				try {
					Subscriptor subscriptor = subscriptorLocalService.findByEmailAndCompanyIdAndGroupId(companyId, groupId, email);
					if (subscriptor == null) {
						addSubscriptor(companyId, groupId, name, surname, email, lang, categoryIds, false);	
					} else {
						editSubscriptor(subscriptor.getSubscriptorId(), name, surname, email, lang, categoryIds);
					}
				} catch (PortalException e) {
					throw new ImportException(e.toString() + " (" + recordData + ")", e);
				} catch (RuntimeException e) {
					throw new ImportException(e.toString() + " (" + recordData + ")", e);
				}
				
			}

		} catch (IOException e) {
			throw new ImportException(e);
		} catch (RuntimeException e) {
			throw new ImportException(e);
		}
	}
	
	private void validateNewSubscritor(long companyId, long groupId, String name, String surname, String email) throws PortalException, SystemException {
		
		if (email == null || email.equals("")) {
			throw new EmptyFieldException("email can not be null");
		}

		EmailUtil.validateEmail(email);
		
		Subscriptor subscriptor = subscriptorLocalService.findByEmailAndCompanyIdAndGroupId(companyId, groupId, email);
		if (subscriptor != null) {
			throw new DuplicateSubscriptorException();
		}
	}
	
	private void validateEditSubscritor(Subscriptor subscriptorOld, String nameNew, String surnameNew, String emailNew) throws PortalException, SystemException {
		
		EmailUtil.validateEmail(emailNew);
		
		Subscriptor subscriptor = subscriptorLocalService.findByEmailAndCompanyIdAndGroupId(subscriptorOld.getCompanyId(), subscriptorOld.getGroupId(), emailNew);
		if (subscriptor != null && (subscriptor.getSubscriptorId() != subscriptorOld.getSubscriptorId())) {
			throw new DuplicateSubscriptorException();
		}
	}
		
	
	
	public void remove(long subscriptorId) throws SystemException, PortalException {

		subscriptorCategoryLocalService.deleteBySubscriptorId(subscriptorId);
        subscriptorPersistence.remove(subscriptorId);
	}
	
	public List<Subscriptor> findByKeywords(long companyId, long groupId, String keywords, int start, int end) throws SystemException {
		
		// esto estaria mejor en un "ExtSubscriptorPersistenceImpl", definiendo una "persistence-class" en el service.xml.
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Subscriptor.class);
		Junction junction = RestrictionsFactoryUtil.disjunction();
		junction.add(RestrictionsFactoryUtil.ilike("name", "%" + keywords + "%"));
		junction.add(RestrictionsFactoryUtil.ilike("surname", "%" + keywords + "%"));
		junction.add(RestrictionsFactoryUtil.ilike("email", "%" + keywords + "%"));
		query.add(junction);
		query.add(PropertyFactoryUtil.forName("companyId").eq(new Long(companyId)));
		query.add(PropertyFactoryUtil.forName("groupId").eq(new Long(groupId)));
		query.addOrder(OrderFactoryUtil.asc("email"));

		List results = this.dynamicQuery(query, start, end);

		return (List<Subscriptor>) results;
	}
	
	public int countByKeywords(long companyId, long groupId, String keywords) throws SystemException {
		
		// esto estaria mejor en un "ExtSubscriptorPersistenceImpl", definiendo una "persistence-class" en el service.xml.
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Subscriptor.class);
		Junction junction = RestrictionsFactoryUtil.disjunction();
		junction.add(RestrictionsFactoryUtil.ilike("name", "%" + keywords + "%"));
		junction.add(RestrictionsFactoryUtil.ilike("surname", "%" + keywords + "%"));
		junction.add(RestrictionsFactoryUtil.ilike("email", "%" + keywords + "%"));
		query.add(junction);
		query.add(PropertyFactoryUtil.forName("companyId").eq(new Long(companyId)));
		query.add(PropertyFactoryUtil.forName("groupId").eq(new Long(groupId)));
		query.setProjection(ProjectionFactoryUtil.rowCount());

		List<Long> list = this.dynamicQuery(query);
		Long value = list.get(0);
		// En esta version de liferay el projection rowCount devuelve un Long (en vez de un int). Está mejor así, pero
		// lo paso a int (a pesar de la perdida de rango entre int y long) ya que el search container solo permite int, y los
		// counts autogenerados de los finders tambien devuelven int.
        return value.intValue();
	}
	
	
	public int countByCategoryId(long categoryId) throws SystemException, PortalException {

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(SubscriptorCategory.class);
		query.add(PropertyFactoryUtil.forName("categoryId").eq(categoryId));
		query.setProjection(ProjectionFactoryUtil.rowCount());

		List<Long> list = this.dynamicQuery(query);
		Long value = list.get(0);
		// En esta version de liferay el projection rowCount devuelve un Long (en vez de un int). Está mejor así, pero
		// lo paso a int (a pesar de la perdida de rango entre int y long) ya que el search container solo permite int, y los
		// counts autogenerados de los finders tambien devuelven int.
        return value.intValue();
	}
	
	public List<Subscriptor> findByCategoryId(long categoryId, int start, int end) throws SystemException, PortalException {
	
		// TODO hardcode begin end!!!!
		List<Subscriptor> results = SubscriptorFinderUtil.findByCategoryId(categoryId, start, end);
		
		for (Subscriptor subscriptor : results) {
			_log.info("QUERY OK: " + subscriptor.getFullName());
		}
		
		return results;
	}
	
	public Subscriptor findByEmailAndCompanyIdAndGroupId(long companyId, long groupId, String email) throws SystemException, PortalException {
		
		try {
			Subscriptor subscriptor = subscriptorPersistence.findByEmailAndCompanyIdAndGroupId(companyId, groupId, email);
			return subscriptor;
			
		} catch (NoSuchSubscriptorException e) {
			return null; 
		}
		
	}
	
	public Subscriptor findByUuid(String uuid) throws SystemException, PortalException {
		
		try {
			Subscriptor subscriptor = subscriptorPersistence.findByUuid_First(uuid, null);
			return subscriptor;
		} catch (NoSuchSubscriptorException e) {
			return null;
		}
		
	}
	
	
}