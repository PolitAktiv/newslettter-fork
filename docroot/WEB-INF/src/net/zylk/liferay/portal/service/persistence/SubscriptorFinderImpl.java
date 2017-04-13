package net.zylk.liferay.portal.service.persistence;

import java.util.List;

import net.zylk.liferay.portal.model.Subscriptor;
import net.zylk.liferay.portal.model.impl.SubscriptorImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class SubscriptorFinderImpl extends BasePersistenceImpl<Subscriptor> implements SubscriptorFinder {

	public static final String FIND_BY_CATEGORY_ID = SubscriptorFinder.class.getName() + ".findByCategoryId";
	
	public List<Subscriptor> findByCategoryId(long categoryId, int begin, int end) {

		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_CATEGORY_ID);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ZN_Subscriptor", SubscriptorImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(categoryId);

			return (List<Subscriptor>) QueryUtil.list(q, getDialect(), begin, end);	

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}

		return null;
	}

}