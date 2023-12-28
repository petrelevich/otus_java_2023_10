package ru.otus.reflection;

import java.lang.reflect.Array;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectionArray {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionArray.class);

    public static void main(String[] args) {
        int[] arrayInt = new int[0];

        Class<? extends int[]> clazz = arrayInt.getClass();
        logger.info("isArray: {}", clazz.isArray());
        logger.info("TypeName: {}", clazz.getTypeName());

        Class<?> componentType = clazz.getComponentType();
        logger.info("componentType: {}", componentType);

        logger.info("-- creating Array");

        float[] arrayFloat = (float[]) Array.newInstance(float.class, 5);
        logger.info("length:{}", arrayFloat.length);
        logger.info("created TypeName:{}", arrayFloat.getClass().getTypeName());
    }
}
