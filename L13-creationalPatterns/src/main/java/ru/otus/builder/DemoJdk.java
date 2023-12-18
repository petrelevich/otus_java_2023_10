package ru.otus.builder;

import static java.util.Calendar.MONDAY;

import java.util.Calendar;
import java.util.Locale;

/** Примеры builder в JDK. */
@SuppressWarnings({"java:S106", "java:S1854", "java:S1481"})
public class DemoJdk {
    public static void main(String[] args) {
        // Locale
        Locale locale = new Locale.Builder().setLanguage("ru").setRegion("RU").build();

        // Calendar
        Calendar cal = new Calendar.Builder()
                .setCalendarType("iso8601")
                .setWeekDate(2021, 1, MONDAY)
                .build();

        // StringBuilder
        // not fluent
        StringBuilder builder = new StringBuilder();
        builder.append("a");
        builder.append("b");
        builder.append("c");

        String str = builder.toString();

        System.out.println(str);

        // fluent
        StringBuilder builder2 = new StringBuilder().append("aa ").append("bb ").append("cc");

        String str2 = builder2.toString();

        System.out.println(str2);
    }
}
