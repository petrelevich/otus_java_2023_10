package ru.otus.reflection;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectionCreateObject {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionCreateObject.class);

    public static void main(String[] args) throws Exception {

        Class<DemoClass> clazz = DemoClass.class;
        logger.info("Class Name:{}", clazz.getSimpleName());

        Constructor<?>[] constructors = clazz.getConstructors();
        logger.info("--- constructors:");
        logger.atInfo()
                .setMessage("{}")
                .addArgument(() -> Arrays.toString(constructors))
                .log();

        logger.info("--- creating new object:");
        Constructor<DemoClass> constructor = clazz.getConstructor(String.class);
        DemoClass object = constructor.newInstance("testVal");
        logger.info("value:{}", object.getValuePrivate());
    }
}
