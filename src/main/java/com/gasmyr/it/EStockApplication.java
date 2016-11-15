package com.gasmyr.it;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.gasmyr.it.controller.shop.ShopController;

@SpringBootApplication
public class EStockApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EStockApplication.class);
	}

	public static void main(String[] args) {
		new File(ShopController.uploadfilesPath).mkdirs();
		SpringApplication.run(EStockApplication.class, args);
	}
}
