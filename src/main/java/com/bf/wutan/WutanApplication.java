package com.bf.wutan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.bf.wutan.mapper")
@SpringBootApplication
public class WutanApplication {

    public static void main(String[] args) {
        SpringApplication.run(WutanApplication.class, args);
    }

}
