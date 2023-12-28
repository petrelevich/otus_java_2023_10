package ru.otus.reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"java:S1104", "java:S1144"})
public class DemoClass {
    private static final Logger logger = LoggerFactory.getLogger(DemoClass.class);

    public int publicFieldForDemo;

    private String valuePrivate = "initValue";

    public DemoClass(String valuePrivate) {
        this.valuePrivate = valuePrivate;
    }

    public String getValuePrivate() {
        return valuePrivate;
    }

    public void setValuePrivate(String valuePrivate) {
        this.valuePrivate = valuePrivate;
    }

    private void privateMethod() {
        logger.info("privateMethod executed");
    }

    @Override
    @SimpleAnnotation
    public String toString() {
        return "DemoClass{" + "publicFieldForDemo=" + publicFieldForDemo + ", value='" + valuePrivate + '\'' + '}';
    }
}
