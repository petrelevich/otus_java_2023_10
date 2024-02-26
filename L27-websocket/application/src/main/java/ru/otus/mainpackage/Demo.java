package ru.otus.mainpackage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.otus.mainpackage.configs.AppConfigForBean;
import ru.otus.mainpackage.configs.AppConfigForConfigProps;

// http://localhost:8080/actuator/health

@SpringBootApplication
public class Demo {

    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }
}
