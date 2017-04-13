package net.zylk.liferay.portal.service.base;

import net.zylk.liferay.portal.service.NewsletterLocalServiceUtil;

import java.util.Arrays;

/**
 * @author zylk.net
 * @generated
 */
public class NewsletterLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName72;
    private String[] _methodParameterTypes72;
    private String _methodName73;
    private String[] _methodParameterTypes73;
    private String _methodName78;
    private String[] _methodParameterTypes78;
    private String _methodName79;
    private String[] _methodParameterTypes79;
    private String _methodName81;
    private String[] _methodParameterTypes81;
    private String _methodName82;
    private String[] _methodParameterTypes82;
    private String _methodName83;
    private String[] _methodParameterTypes83;
    private String _methodName84;
    private String[] _methodParameterTypes84;
    private String _methodName85;
    private String[] _methodParameterTypes85;
    private String _methodName86;
    private String[] _methodParameterTypes86;
    private String _methodName87;
    private String[] _methodParameterTypes87;
    private String _methodName88;
    private String[] _methodParameterTypes88;

    public NewsletterLocalServiceClpInvoker() {
        _methodName0 = "addNewsletter";

        _methodParameterTypes0 = new String[] {
                "net.zylk.liferay.portal.model.Newsletter"
            };

        _methodName1 = "createNewsletter";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteNewsletter";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteNewsletter";

        _methodParameterTypes3 = new String[] {
                "net.zylk.liferay.portal.model.Newsletter"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchNewsletter";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getNewsletter";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getNewsletters";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getNewslettersCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateNewsletter";

        _methodParameterTypes15 = new String[] {
                "net.zylk.liferay.portal.model.Newsletter"
            };

        _methodName72 = "getBeanIdentifier";

        _methodParameterTypes72 = new String[] {  };

        _methodName73 = "setBeanIdentifier";

        _methodParameterTypes73 = new String[] { "java.lang.String" };

        _methodName78 = "addNewsletter";

        _methodParameterTypes78 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String", "long",
                "java.util.Map", "java.lang.String", "long", "boolean", "int",
                "java.util.Date"
            };

        _methodName79 = "editNewsletter";

        _methodParameterTypes79 = new String[] {
                "long", "java.lang.String", "java.lang.String", "long",
                "java.util.Map", "java.lang.String", "long", "boolean", "int",
                "java.util.Date"
            };

        _methodName81 = "remove";

        _methodParameterTypes81 = new String[] { "long" };

        _methodName82 = "findAll";

        _methodParameterTypes82 = new String[] {  };

        _methodName83 = "findByCompanyIdAndGroupId";

        _methodParameterTypes83 = new String[] { "long", "long", "int", "int" };

        _methodName84 = "countByCompanyIdAndGroupId";

        _methodParameterTypes84 = new String[] { "long", "long" };

        _methodName85 = "preview";

        _methodParameterTypes85 = new String[] {
                "long", "java.lang.String",
                "com.liferay.portal.theme.ThemeDisplay"
            };

        _methodName86 = "viewOnline";

        _methodParameterTypes86 = new String[] { "long", "long" };

        _methodName87 = "viewArchive";

        _methodParameterTypes87 = new String[] { "long" };

        _methodName88 = "send";

        _methodParameterTypes88 = new String[] {
                "long", "java.util.Date", "boolean"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return NewsletterLocalServiceUtil.addNewsletter((net.zylk.liferay.portal.model.Newsletter) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return NewsletterLocalServiceUtil.createNewsletter(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return NewsletterLocalServiceUtil.deleteNewsletter(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return NewsletterLocalServiceUtil.deleteNewsletter((net.zylk.liferay.portal.model.Newsletter) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return NewsletterLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return NewsletterLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return NewsletterLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return NewsletterLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return NewsletterLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return NewsletterLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return NewsletterLocalServiceUtil.fetchNewsletter(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return NewsletterLocalServiceUtil.getNewsletter(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return NewsletterLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return NewsletterLocalServiceUtil.getNewsletters(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return NewsletterLocalServiceUtil.getNewslettersCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return NewsletterLocalServiceUtil.updateNewsletter((net.zylk.liferay.portal.model.Newsletter) arguments[0]);
        }

        if (_methodName72.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
            return NewsletterLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName73.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
            NewsletterLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName78.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
            return NewsletterLocalServiceUtil.addNewsletter(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                ((Long) arguments[4]).longValue(),
                (java.util.Map<java.util.Locale, java.lang.String>) arguments[5],
                (java.lang.String) arguments[6],
                ((Long) arguments[7]).longValue(),
                ((Boolean) arguments[8]).booleanValue(),
                ((Integer) arguments[9]).intValue(),
                (java.util.Date) arguments[10]);
        }

        if (_methodName79.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
            return NewsletterLocalServiceUtil.editNewsletter(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                ((Long) arguments[3]).longValue(),
                (java.util.Map<java.util.Locale, java.lang.String>) arguments[4],
                (java.lang.String) arguments[5],
                ((Long) arguments[6]).longValue(),
                ((Boolean) arguments[7]).booleanValue(),
                ((Integer) arguments[8]).intValue(),
                (java.util.Date) arguments[9]);
        }

        if (_methodName81.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
            NewsletterLocalServiceUtil.remove(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName82.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
            return NewsletterLocalServiceUtil.findAll();
        }

        if (_methodName83.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
            return NewsletterLocalServiceUtil.findByCompanyIdAndGroupId(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue());
        }

        if (_methodName84.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
            return NewsletterLocalServiceUtil.countByCompanyIdAndGroupId(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName85.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
            return NewsletterLocalServiceUtil.preview(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (com.liferay.portal.theme.ThemeDisplay) arguments[2]);
        }

        if (_methodName86.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
            return NewsletterLocalServiceUtil.viewOnline(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName87.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
            return NewsletterLocalServiceUtil.viewArchive(((Long) arguments[0]).longValue());
        }

        if (_methodName88.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
            NewsletterLocalServiceUtil.send(((Long) arguments[0]).longValue(),
                (java.util.Date) arguments[1],
                ((Boolean) arguments[2]).booleanValue());

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
