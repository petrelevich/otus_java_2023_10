package ru.otus.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnnotationDemo {
    private static final Logger logger = LoggerFactory.getLogger(AnnotationDemo.class);

    public static void main(String[] args) {
        AnyClass anyClass = new AnyClass(1, 2);

        for (Field field : anyClass.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(AnnotationField.class)) {
                logger.info("field \"{}\" has annotation%n", field.getName());
            }
        }

        for (Method method : anyClass.getClass().getDeclaredMethods()) {
            Annotation[] annotations = method.getAnnotations();
            if (annotations.length > 0) {
                logger.info("method \"{}\", has annotations:%n", method.getName());
            }
            for (Annotation annotation : annotations) {
                logger.info("");
                logger.info(annotation.annotationType().getName());
                if (annotation instanceof AnnotationMethod annotationMethod) {
                    logger.info("");
                    logger.info("AnnotationMethod runLevel = {}", annotationMethod.runLevel());
                }
            }
        }
    }
}
