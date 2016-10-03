package com.gasmyr.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.gasmyr.it.model.Shop;
import com.gasmyr.it.service.interfaces.ShopRepository;

@SpringBootApplication
public class EStockApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EStockApplication.class, args);
		ShopRepository shopRepository = context.getBean(ShopRepository.class);
		Shop shop = new Shop();
		shop.setName("name");
		shop.setDescription("description");
		shop.setPhonenumber("672518191");
		shopRepository.save(shop);
	}
}
