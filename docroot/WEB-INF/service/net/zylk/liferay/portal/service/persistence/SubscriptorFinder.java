package net.zylk.liferay.portal.service.persistence;

public interface SubscriptorFinder {
    public java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByCategoryId(
        long categoryId, int begin, int end);
}
