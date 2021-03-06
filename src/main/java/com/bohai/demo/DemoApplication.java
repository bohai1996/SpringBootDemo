package com.bohai.demo;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            System.out.println("SpringBoot 默认为我们提供的bean:");
//            ctx.get
        };
    }

}
