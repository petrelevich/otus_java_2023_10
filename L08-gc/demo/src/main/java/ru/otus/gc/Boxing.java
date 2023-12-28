package ru.otus.gc;

/*
-Xms256m
-Xmx256m
-verbose:gc
-XX:+UseG1GC
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"java:S1144", "java:S125"})
public class Boxing {
    private static final Logger logger = LoggerFactory.getLogger(Boxing.class);

    public static void main(String[] args) throws InterruptedException {
        calcInteger();
        //        calcInt();
        logger.info("done");
    }

    private static void calcInteger() throws InterruptedException {
        final int limit = Integer.MAX_VALUE;
        Integer counter = 0;
        for (int idx = 0; idx < limit; idx++) {

            counter += Integer.valueOf(1);

            if (idx % 1_000_000 == 0) {
                Thread.sleep(1000);
            }
        }
        logger.info("{}", counter);
    }

    private static void calcInt() throws InterruptedException {
        final int limit = Integer.MAX_VALUE;
        int counter = 0;
        for (int idx = 0; idx < limit; idx++) {

            counter += 1;

            if (idx % 1_000_000 == 0) {
                Thread.sleep(1000);
            }
        }
        logger.info("{}", counter);
    }
}
