package com.geopark;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.geopark.web.mapper")
public class GeoparkWebApplication {

	public static void main(String[] args) {

		SpringApplication.run(GeoparkWebApplication.class, args);
	}

}
