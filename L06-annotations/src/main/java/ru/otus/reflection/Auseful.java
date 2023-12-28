package ru.otus.reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Auseful {
    private static final Logger logger = LoggerFactory.getLogger(Auseful.class);

    public static void main(String[] args) throws Exception {

        var primitiveString = String.class.isPrimitive();
        var primitiveInt = int.class.isPrimitive();
        logger.info("primitiveString:{}, primitiveInt:{}", primitiveString, primitiveInt);

        int[] arr = {1, 2};
        var isArray = arr.getClass().isArray();
        var componentArr = arr.getClass().getComponentType();
        logger.info("isArray:{}, componentArr:{}", isArray, componentArr);

        Class<?> string = Class.forName("java.lang.String");
        var isIterableString = Iterable.class.isAssignableFrom(string);

        Class<?> list = Class.forName("java.util.ArrayList");
        var isIterableList = Iterable.class.isAssignableFrom(list);
        logger.info("isIterableString:{}, isIterableList:{}", isIterableString, isIterableList);

        var hasAnnotation = DemoClass.class.getMethod("toString").isAnnotationPresent(SimpleAnnotation.class);
        logger.info("hasAnnotation:{}", hasAnnotation);
    }
}
