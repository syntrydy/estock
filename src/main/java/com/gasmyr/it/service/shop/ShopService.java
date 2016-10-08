package com.gasmyr.it.service.shop;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gasmyr.it.model.Shop;

public interface ShopService {

	void add(Shop shop);

	int delete(Shop shop);

	int deleteById(Long id);
	
	void update(Long id,Shop shop);

	Shop findById(Long id);

	List<Shop> findAll();
	
	Page<Shop> findAllByPage(Pageable page);

}
