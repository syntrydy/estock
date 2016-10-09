package com.gasmyr.it;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gasmyr.it.controller.shop.ShopController;

@SpringBootApplication
public class EStockApplication {

	public static void main(String[] args) {
		 new File(ShopController.uploadfilesPath).mkdirs();
		SpringApplication.run(EStockApplication.class, args);
	}
}
