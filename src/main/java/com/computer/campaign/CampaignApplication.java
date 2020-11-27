package com.computer.campaign;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//@EnableCaching
@SpringBootApplication
@MapperScan("com.computer.campaign.mapper")
public class CampaignApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampaignApplication.class, args);
    }

}
