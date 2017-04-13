package net.zylk.liferay.portal.service.base;

import net.zylk.liferay.portal.service.UserSubscriptionLocalServiceUtil;

import java.util.Arrays;

/**
 * @author zylk.net
 * @generated
 */
public class UserSubscriptionLocalServiceClpInvoker {
    private String _methodName60;
    private String[] _methodParameterTypes60;
    private String _methodName61;
    private String[] _methodParameterTypes61;
    private String _methodName64;
    private String[] _methodParameterTypes64;
    private String _methodName65;
    private String[] _methodParameterTypes65;
    private String _methodName66;
    private String[] _methodParameterTypes66;
    private String _methodName68;
    private String[] _methodParameterTypes68;
    private String _methodName69;
    private String[] _methodParameterTypes69;

    public UserSubscriptionLocalServiceClpInvoker() {
        _methodName60 = "getBeanIdentifier";

        _methodParameterTypes60 = new String[] {  };

        _methodName61 = "setBeanIdentifier";

        _methodParameterTypes61 = new String[] { "java.lang.String" };

        _methodName64 = "requestSubscription";

        _methodParameterTypes64 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "long[][]"
            };

        _methodName65 = "confirmSubscription";

        _methodParameterTypes65 = new String[] { "java.lang.String" };

        _methodName66 = "confirmUnsubscription";

        _methodParameterTypes66 = new String[] { "java.lang.String" };

        _methodName68 = "generateUnsubscriptionUrl";

        _methodParameterTypes68 = new String[] {
                "long", "long", "java.lang.String"
            };

        _methodName69 = "validateTicket";

        _methodParameterTypes69 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName60.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
            return UserSubscriptionLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName61.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
            UserSubscriptionLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName64.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
            UserSubscriptionLocalServiceUtil.requestSubscription(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5], (long[]) arguments[6]);

            return null;
        }

        if (_methodName65.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
            return UserSubscriptionLocalServiceUtil.confirmSubscription((java.lang.String) arguments[0]);
        }

        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return UserSubscriptionLocalServiceUtil.confirmUnsubscription((java.lang.String) arguments[0]);
        }

        if (_methodName68.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
            return UserSubscriptionLocalServiceUtil.generateUnsubscriptionUrl(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName69.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
            return UserSubscriptionLocalServiceUtil.validateTicket((java.lang.String) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
