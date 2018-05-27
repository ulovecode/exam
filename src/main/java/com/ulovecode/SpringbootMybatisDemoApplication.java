package com.ulovecode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;

@SpringBootApplication
@EnableTransactionManagement
public class
SpringbootMybatisDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisDemoApplication.class, args);

    }
}
