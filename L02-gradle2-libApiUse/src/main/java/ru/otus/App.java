/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ru.otus;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String... args) {
        // Видим класс из модуля L02-gradle2-libApi
        AppFromL01.say();

        // Случай 1
        // в модуле L02-gradle2-libApi стоит api 'com.google.guava:guava'
        // и тут guava доступна, т.е. зависимость "протекла"
        logger.info("{}", com.google.common.collect.Lists.reverse(new ArrayList<>()));

        // Случай 2
        // в модуле L02-gradle2-libApi стоит implementation 'com.google.guava:guava'
        // и тут guava НЕ доступна, т.е. зависимость "изолирована"
    }
}