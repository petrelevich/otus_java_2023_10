package ru.otus.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {
    private static final Logger logger = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 128;
        i2 -=1;

        System.out.println(i1 == i2);

        // Есть сложные системы
        var systemA = new HellSystemA();
        var systemB = new HellSystemB();

        // Передаем сложные системы в фасад
        var facade = new Facade(systemA, systemB);
        // Вызываем "простое" действие
        facade.simpleAction();
        // Работаем только с фасадом => проще изменять системы за фасадом
    }
}
