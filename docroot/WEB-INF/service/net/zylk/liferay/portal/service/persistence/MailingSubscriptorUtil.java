package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import net.zylk.liferay.portal.model.MailingSubscriptor;

import java.util.List;

/**
 * The persistence utility for the mailing subscriptor service. This utility wraps {@link MailingSubscriptorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author zylk.net
 * @see MailingSubscriptorPersistence
 * @see MailingSubscriptorPersistenceImpl
 * @generated
 */
public class MailingSubscriptorUtil {
    private static MailingSubscriptorPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(MailingSubscriptor mailingSubscriptor) {
        getPersistence().clearCache(mailingSubscriptor);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<MailingSubscriptor> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<MailingSubscriptor> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<MailingSubscriptor> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static MailingSubscriptor update(
        MailingSubscriptor mailingSubscriptor) throws SystemException {
        return getPersistence().update(mailingSubscriptor);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static MailingSubscriptor update(
        MailingSubscriptor mailingSubscriptor, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(mailingSubscriptor, serviceContext);
    }

    /**
    * Caches the mailing subscriptor in the entity cache if it is enabled.
    *
    * @param mailingSubscriptor the mailing subscriptor
    */
    public static void cacheResult(
        net.zylk.liferay.portal.model.MailingSubscriptor mailingSubscriptor) {
        getPersistence().cacheResult(mailingSubscriptor);
    }

    /**
    * Caches the mailing subscriptors in the entity cache if it is enabled.
    *
    * @param mailingSubscriptors the mailing subscriptors
    */
    public static void cacheResult(
        java.util.List<net.zylk.liferay.portal.model.MailingSubscriptor> mailingSubscriptors) {
        getPersistence().cacheResult(mailingSubscriptors);
    }

    /**
    * Creates a new mailing subscriptor with the primary key. Does not add the mailing subscriptor to the database.
    *
    * @param mailingSubscriptorId the primary key for the new mailing subscriptor
    * @return the new mailing subscriptor
    */
    public static net.zylk.liferay.portal.model.MailingSubscriptor create(
        long mailingSubscriptorId) {
        return getPersistence().create(mailingSubscriptorId);
    }

    /**
    * Removes the mailing subscriptor with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param mailingSubscriptorId the primary key of the mailing subscriptor
    * @return the mailing subscriptor that was removed
    * @throws net.zylk.liferay.portal.NoSuchMailingSubscriptorException if a mailing subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.MailingSubscriptor remove(
        long mailingSubscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingSubscriptorException {
        return getPersistence().remove(mailingSubscriptorId);
    }

    public static net.zylk.liferay.portal.model.MailingSubscriptor updateImpl(
        net.zylk.liferay.portal.model.MailingSubscriptor mailingSubscriptor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(mailingSubscriptor);
    }

    /**
    * Returns the mailing subscriptor with the primary key or throws a {@link net.zylk.liferay.portal.NoSuchMailingSubscriptorException} if it could not be found.
    *
    * @param mailingSubscriptorId the primary key of the mailing subscriptor
    * @return the mailing subscriptor
    * @throws net.zylk.liferay.portal.NoSuchMailingSubscriptorException if a mailing subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.MailingSubscriptor findByPrimaryKey(
        long mailingSubscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.zylk.liferay.portal.NoSuchMailingSubscriptorException {
        return getPersistence().findByPrimaryKey(mailingSubscriptorId);
    }

    /**
    * Returns the mailing subscriptor with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param mailingSubscriptorId the primary key of the mailing subscriptor
    * @return the mailing subscriptor, or <code>null</code> if a mailing subscriptor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.zylk.liferay.portal.model.MailingSubscriptor fetchByPrimaryKey(
        long mailingSubscriptorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(mailingSubscriptorId);
    }

    /**
    * Returns all the mailing subscriptors.
    *
    * @return the mailing subscriptors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.MailingSubscriptor> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the mailing subscriptors.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingSubscriptorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of mailing subscriptors
    * @param end the upper bound of the range of mailing subscriptors (not inclusive)
    * @return the range of mailing subscriptors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.MailingSubscriptor> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the mailing subscriptors.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.MailingSubscriptorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of mailing subscriptors
    * @param end the upper bound of the range of mailing subscriptors (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of mailing subscriptors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.zylk.liferay.portal.model.MailingSubscriptor> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the mailing subscriptors from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of mailing subscriptors.
    *
    * @return the number of mailing subscriptors
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static MailingSubscriptorPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (MailingSubscriptorPersistence) PortletBeanLocatorUtil.locate(net.zylk.liferay.portal.service.ClpSerializer.getServletContextName(),
                    MailingSubscriptorPersistence.class.getName());

            ReferenceRegistry.registerReference(MailingSubscriptorUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(MailingSubscriptorPersistence persistence) {
    }
}
