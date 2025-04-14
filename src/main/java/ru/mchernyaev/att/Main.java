package ru.mchernyaev.att;

import di.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var controller = context.getBean(ApplicationController.class);
        try {
            controller.run(args);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
