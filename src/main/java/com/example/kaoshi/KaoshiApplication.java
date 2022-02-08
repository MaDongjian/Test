package com.example.kaoshi;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.kaoshi.dao")
/*@EnableScheduling*/
public class KaoshiApplication extends SpringBootServletInitializer {
    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(KaoshiApplication.class);
    }*/
    public static void main(String[] args) {

        SpringApplication.run(KaoshiApplication.class, args);
    }

}
