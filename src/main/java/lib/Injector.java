package lib;

import exceptions.AnnotationException;
import factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {

    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        Object instance = declaredConstructor.newInstance();

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.getAnnotation(Inject.class) != null) {
                declaredField.setAccessible(true);
                Object dao = Factory.getDao(declaredField.getType());
                if (!dao.getClass().isAnnotationPresent(Dao.class)) {
                    throw new AnnotationException("Does not exist Dao annotation at this class!");
                }
                declaredField.set(instance, dao);
            }
        }
        return instance;
    }
}
