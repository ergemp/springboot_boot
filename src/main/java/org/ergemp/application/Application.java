package org.ergemp.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAsync
@EnableSwagger2
@SpringBootApplication
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages =   "org.ergemp.controller," +
                                "org.ergemp.configuration," +
                                "org.ergemp.component," +
                                "org.ergemp.service," +
                                "org.ergemp.interceptor," +
                                "org.ergemp.repository")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
