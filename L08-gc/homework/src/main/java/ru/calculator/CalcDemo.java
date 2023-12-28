package ru.calculator;

/*
-Xms256m
-Xmx256m
-XX:+HeapDumpOnOutOfMemoryError
-XX:HeapDumpPath=./logs/heapdump.hprof
-XX:+UseG1GC
-Xlog:gc=debug:file=./logs/gc-%p-%t.log:tags,uptime,time,level:filecount=5,filesize=10m
*/

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalcDemo {
    private static final Logger logger = LoggerFactory.getLogger(CalcDemo.class);

    public static void main(String[] args) {
        long counter = 100_000_000;
        var summator = new Summator();
        long startTime = System.currentTimeMillis();

        for (var idx = 0; idx < counter; idx++) {
            var data = new Data(idx);
            summator.calc(data);

            if (idx % 10_000_000 == 0) {
                logger.info("{} current idx:{}", LocalDateTime.now(), idx);
            }
        }

        long delta = System.currentTimeMillis() - startTime;
        logger.info("{}", summator.getPrevValue());
        logger.info("{}", summator.getPrevPrevValue());
        logger.info("{}", summator.getSumLastThreeValues());
        logger.info("{}", summator.getSomeValue());
        logger.info("{}", summator.getSum());
        logger.info("spend msec:{}, sec:{}", delta, (delta / 1000));
    }
}
