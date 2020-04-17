package com.yogie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: prac-mq
 * @Date: 2019/12/17 21:37
 * @Author: Chenyogie
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.yogie.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
