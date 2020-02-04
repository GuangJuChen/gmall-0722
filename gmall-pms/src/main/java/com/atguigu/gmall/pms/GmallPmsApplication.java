/**
 * Copyright (c) 2016-2019 谷粒开源 All rights reserved.
 *
 * https://www.guli.cloud
 *
 * 版权所有，侵权必究！
 */

package com.atguigu.gmall.pms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("com.atguigu.gmall.pms.dao")
public class GmallPmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmallPmsApplication.class, args);
	}

}