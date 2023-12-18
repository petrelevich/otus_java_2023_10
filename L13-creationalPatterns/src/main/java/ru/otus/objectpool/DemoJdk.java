package ru.otus.objectpool;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/** Примеры Object Poll в JDK. */
@SuppressWarnings({"java:S106", "java:S4973", "java:S2129", "java:S1192", "java:S2095"})
public class DemoJdk {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("----- String -----");
        // Конструктор -- в куче
        String str1 = "Hello, OTUS";
        String str2 = "Hello, OTUS";
        System.out.println("str1 == str2 -> " + (str1 == str2));

        // Строковый литерал -- в пуле строк (string pool) (интернирование, interning)
        // Конструктор -- в куче
        String str3 = new String("Hello, OTUS");
        String str4 = new String("Hello, OTUS");
        System.out.println("str3 == str4 -> " + (str3 == str4));

        // intern() - помещаем в пул
        String str5 = new String("Hello, OTUS").intern();
        System.out.println("str1 == str5 -> " + (str1 == str5));

        System.out.println("----- Thread -----");
        // Один поток
        Thread thread = new Thread(() -> System.out.println("Hello from Thread"));
        thread.start();

        // Пул с двумя потоками
        ExecutorService fixed = Executors.newFixedThreadPool(5);
        fixed.submit(() -> System.out.println("Hello from FixedThreadPool"));
        // Какой еще здесь паттерн, который сегодня прошли?

        // Кэширующий пул потоков, создает потоки по мере необходимости,
        // переиспользует неактивные потоки
        ExecutorService cached = Executors.newCachedThreadPool();
        cached.submit(() -> System.out.println("Hello from CachedThreadPool"));

        // Отложенный, периодический запуск
        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
        scheduled.scheduleAtFixedRate(() -> System.out.println("Hello from ScheduledThreadPool"), 0, 1, SECONDS);

        Thread.sleep(SECONDS.toMillis(5));
        scheduled.shutdown();
        fixed.shutdownNow();
        cached.shutdown();
    }
}
