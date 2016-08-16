package com.omegamendes.dash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by mame on 16/08/2016.
 */

@SpringBootApplication
@EnableAutoConfiguration
public class DashApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DashApp.class, args);
    }
}
