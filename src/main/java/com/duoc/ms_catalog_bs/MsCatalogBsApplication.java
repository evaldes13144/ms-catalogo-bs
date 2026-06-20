package com.duoc.ms_catalog_bs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsCatalogBsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCatalogBsApplication.class, args);
	}

}
