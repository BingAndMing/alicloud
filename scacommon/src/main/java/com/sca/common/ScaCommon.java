package com.sca.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName
 * @Author dell
 * @Date 2021/3/17 11:52
 * @Version 1.0
 * @Description
 **/
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.sca.common.dao")
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ScaCommon {
	public static void main (String[] args) {
		SpringApplication.run(ScaCommon.class,args);
	}
}
