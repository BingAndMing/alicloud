package com.sca.order;

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
 * @Date 2021/3/17 14:28
 * @Version 1.0
 * @Description
 **/
@SuppressWarnings("all")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.sca.order.dao")
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ScaOrder {
	public static void main (String[] args) {
		SpringApplication.run(ScaOrder.class, args);
	}
}
