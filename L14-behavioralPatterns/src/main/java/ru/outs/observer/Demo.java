package ru.outs.observer;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        var producer = new EventProducer();
        var consumerA = new ConsumerA();
        var consumerB = new ConsumerB();

        var list = new ArrayList<Integer>();
        list.add(1);
        for (var i : list) {
            if (i == 1)
                list.add(2);
        }

        Boolean[] first = {true};

        Listener temp = data -> {
            System.out.println("Temp listener " + data);
            if (first[0]) {
                first[0] = false;
                producer.event("EventB");
            }
        };

        producer.addListener(temp);
        producer.addListener(consumerA);
        //producer.addListener(consumerB.getListener());

        producer.event("eventA");
        //producer.event("eventB");

        //producer.removeListener(temp);

        //Критически важно удалять, когда не нужны
        //producer.removeListener(consumerA);
        //producer.removeListener(consumerB.getListener());

        //producer.event("eventC");
        //producer.event("eventD");
    }
}
