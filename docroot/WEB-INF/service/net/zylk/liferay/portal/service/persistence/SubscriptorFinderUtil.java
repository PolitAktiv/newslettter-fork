package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class SubscriptorFinderUtil {
    private static SubscriptorFinder _finder;

    public static java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByCategoryId(
        long categoryId, int begin, int end) {
        return getFinder().findByCategoryId(categoryId, begin, end);
    }

    public static SubscriptorFinder getFinder() {
        if (_finder == null) {
            _finder = (SubscriptorFinder) PortletBeanLocatorUtil.locate(net.zylk.liferay.portal.service.ClpSerializer.getServletContextName(),
                    SubscriptorFinder.class.getName());

            ReferenceRegistry.registerReference(SubscriptorFinderUtil.class,
                "_finder");
        }

        return _finder;
    }

    public void setFinder(SubscriptorFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(SubscriptorFinderUtil.class,
            "_finder");
    }
}
