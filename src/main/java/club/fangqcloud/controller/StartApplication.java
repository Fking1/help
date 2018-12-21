package club.fangqcloud.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"club.fangqcloud.controller","club.fangqcloud.impl","club.fangqcloud.pojo"})
@MapperScan(basePackages = {"club.fangqcloud.mapper"})
public class StartApplication {
    public static void main(String[] args){
        SpringApplication.run(StartApplication.class,args);
    }
}
