package com.meety;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by miki on 04.06.2015.
 */
@SpringBootApplication
@ComponentScan("com.meety")
public class MeetyBootStrap {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MeetyBootStrap.class, args);
    }
}
