package net.zylk.liferay.portal.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import net.zylk.liferay.portal.model.CategoryClp;
import net.zylk.liferay.portal.model.MailingClp;
import net.zylk.liferay.portal.model.MailingLangClp;
import net.zylk.liferay.portal.model.MailingSubscriptorClp;
import net.zylk.liferay.portal.model.NewsletterClp;
import net.zylk.liferay.portal.model.SubscriptorCategoryClp;
import net.zylk.liferay.portal.model.SubscriptorClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static String _servletContextName;
    private static boolean _useReflectionToTranslateThrowable = true;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "zn-newsletter-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "zn-newsletter-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "zn-newsletter-portlet";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(CategoryClp.class.getName())) {
            return translateInputCategory(oldModel);
        }

        if (oldModelClassName.equals(MailingClp.class.getName())) {
            return translateInputMailing(oldModel);
        }

        if (oldModelClassName.equals(MailingLangClp.class.getName())) {
            return translateInputMailingLang(oldModel);
        }

        if (oldModelClassName.equals(MailingSubscriptorClp.class.getName())) {
            return translateInputMailingSubscriptor(oldModel);
        }

        if (oldModelClassName.equals(NewsletterClp.class.getName())) {
            return translateInputNewsletter(oldModel);
        }

        if (oldModelClassName.equals(SubscriptorClp.class.getName())) {
            return translateInputSubscriptor(oldModel);
        }

        if (oldModelClassName.equals(SubscriptorCategoryClp.class.getName())) {
            return translateInputSubscriptorCategory(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputCategory(BaseModel<?> oldModel) {
        CategoryClp oldClpModel = (CategoryClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getCategoryRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputMailing(BaseModel<?> oldModel) {
        MailingClp oldClpModel = (MailingClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getMailingRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputMailingLang(BaseModel<?> oldModel) {
        MailingLangClp oldClpModel = (MailingLangClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getMailingLangRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputMailingSubscriptor(BaseModel<?> oldModel) {
        MailingSubscriptorClp oldClpModel = (MailingSubscriptorClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getMailingSubscriptorRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputNewsletter(BaseModel<?> oldModel) {
        NewsletterClp oldClpModel = (NewsletterClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getNewsletterRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputSubscriptor(BaseModel<?> oldModel) {
        SubscriptorClp oldClpModel = (SubscriptorClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getSubscriptorRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputSubscriptorCategory(
        BaseModel<?> oldModel) {
        SubscriptorCategoryClp oldClpModel = (SubscriptorCategoryClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getSubscriptorCategoryRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "net.zylk.liferay.portal.model.impl.CategoryImpl")) {
            return translateOutputCategory(oldModel);
        }

        if (oldModelClassName.equals(
                    "net.zylk.liferay.portal.model.impl.MailingImpl")) {
            return translateOutputMailing(oldModel);
        }

        if (oldModelClassName.equals(
                    "net.zylk.liferay.portal.model.impl.MailingLangImpl")) {
            return translateOutputMailingLang(oldModel);
        }

        if (oldModelClassName.equals(
                    "net.zylk.liferay.portal.model.impl.MailingSubscriptorImpl")) {
            return translateOutputMailingSubscriptor(oldModel);
        }

        if (oldModelClassName.equals(
                    "net.zylk.liferay.portal.model.impl.NewsletterImpl")) {
            return translateOutputNewsletter(oldModel);
        }

        if (oldModelClassName.equals(
                    "net.zylk.liferay.portal.model.impl.SubscriptorImpl")) {
            return translateOutputSubscriptor(oldModel);
        }

        if (oldModelClassName.equals(
                    "net.zylk.liferay.portal.model.impl.SubscriptorCategoryImpl")) {
            return translateOutputSubscriptorCategory(oldModel);
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Throwable translateThrowable(Throwable throwable) {
        if (_useReflectionToTranslateThrowable) {
            try {
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

                objectOutputStream.writeObject(throwable);

                objectOutputStream.flush();
                objectOutputStream.close();

                UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
                        0, unsyncByteArrayOutputStream.size());

                Thread currentThread = Thread.currentThread();

                ClassLoader contextClassLoader = currentThread.getContextClassLoader();

                ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
                        contextClassLoader);

                throwable = (Throwable) objectInputStream.readObject();

                objectInputStream.close();

                return throwable;
            } catch (SecurityException se) {
                if (_log.isInfoEnabled()) {
                    _log.info("Do not use reflection to translate throwable");
                }

                _useReflectionToTranslateThrowable = false;
            } catch (Throwable throwable2) {
                _log.error(throwable2, throwable2);

                return throwable2;
            }
        }

        Class<?> clazz = throwable.getClass();

        String className = clazz.getName();

        if (className.equals(PortalException.class.getName())) {
            return new PortalException();
        }

        if (className.equals(SystemException.class.getName())) {
            return new SystemException();
        }

        if (className.equals("net.zylk.liferay.portal.NoSuchCategoryException")) {
            return new net.zylk.liferay.portal.NoSuchCategoryException();
        }

        if (className.equals("net.zylk.liferay.portal.NoSuchMailingException")) {
            return new net.zylk.liferay.portal.NoSuchMailingException();
        }

        if (className.equals(
                    "net.zylk.liferay.portal.NoSuchMailingLangException")) {
            return new net.zylk.liferay.portal.NoSuchMailingLangException();
        }

        if (className.equals(
                    "net.zylk.liferay.portal.NoSuchMailingSubscriptorException")) {
            return new net.zylk.liferay.portal.NoSuchMailingSubscriptorException();
        }

        if (className.equals(
                    "net.zylk.liferay.portal.NoSuchNewsletterException")) {
            return new net.zylk.liferay.portal.NoSuchNewsletterException();
        }

        if (className.equals(
                    "net.zylk.liferay.portal.NoSuchSubscriptorException")) {
            return new net.zylk.liferay.portal.NoSuchSubscriptorException();
        }

        if (className.equals(
                    "net.zylk.liferay.portal.NoSuchSubscriptorCategoryException")) {
            return new net.zylk.liferay.portal.NoSuchSubscriptorCategoryException();
        }

        return throwable;
    }

    public static Object translateOutputCategory(BaseModel<?> oldModel) {
        CategoryClp newModel = new CategoryClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setCategoryRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputMailing(BaseModel<?> oldModel) {
        MailingClp newModel = new MailingClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setMailingRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputMailingLang(BaseModel<?> oldModel) {
        MailingLangClp newModel = new MailingLangClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setMailingLangRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputMailingSubscriptor(
        BaseModel<?> oldModel) {
        MailingSubscriptorClp newModel = new MailingSubscriptorClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setMailingSubscriptorRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputNewsletter(BaseModel<?> oldModel) {
        NewsletterClp newModel = new NewsletterClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setNewsletterRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputSubscriptor(BaseModel<?> oldModel) {
        SubscriptorClp newModel = new SubscriptorClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setSubscriptorRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputSubscriptorCategory(
        BaseModel<?> oldModel) {
        SubscriptorCategoryClp newModel = new SubscriptorCategoryClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setSubscriptorCategoryRemoteModel(oldModel);

        return newModel;
    }
}
