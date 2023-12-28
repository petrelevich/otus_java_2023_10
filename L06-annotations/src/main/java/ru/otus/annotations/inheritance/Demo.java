package ru.otus.annotations.inheritance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {
    private static final Logger logger = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {

        Class<?> clazz = EmailUse.class;

        logger.info("immutableEmail:{}", clazz.isAnnotationPresent(ImmutableEmail.class));
        logger.info("email:{}", clazz.isAnnotationPresent(Email.class));
        logger.info("immutable:{}", clazz.isAnnotationPresent(Immutable.class));

        logger.info("------------------");

        Class<?> clazzChild = EmailUseChild.class;

        logger.info("immutableEmail:{}", clazzChild.isAnnotationPresent(ImmutableEmail.class));
        logger.info("email:{}", clazzChild.isAnnotationPresent(Email.class));
        logger.info("immutable:{}", clazzChild.isAnnotationPresent(Immutable.class));

        logger.info("------------------");
        logger.info("{}", EmailUseChild.class.isAssignableFrom(EmailUse.class));
        logger.info("{}", EmailUse.class.isAssignableFrom(EmailUseChild.class));
    }
}
