package com.epidemic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.epidemic.dao")
@SpringBootApplication
public class MyWebdemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyWebdemoApplication.class,args);
    }
}
