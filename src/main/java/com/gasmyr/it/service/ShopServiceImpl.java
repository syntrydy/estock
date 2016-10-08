package com.gasmyr.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gasmyr.it.model.Shop;
import com.gasmyr.it.service.interfaces.ShopRepository;
import com.gasmyr.it.service.interfaces.Shopable;

@Service
public class ShopServiceImpl implements Shopable {

	@Autowired
	private ShopRepository shopRepository;

	@Override
	public void add(Shop shop) {
		shopRepository.save(shop);
	}

	@Override
	public int delete(Shop shop) {
		if (shop != null) {
			shopRepository.delete(shop);
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public Shop findById(Long id) {
		return shopRepository.findOne(id);
	}

	@Override
	public int deleteById(Long id) {
		if (id == null) {
			return -1;
		} else {
			shopRepository.delete(id);
			return 1;
		}

	}

	@Override
	public List<Shop> findAll() {
		return (List<Shop>) shopRepository.findAll();
	}

	@Override
	public Page<Shop> findAllByPage(Pageable pageable) {
		return shopRepository.findAll(pageable);
	}

	@Override
	public void update(Long id, Shop shop) {
		Shop oldshop = shopRepository.findOne(id);
		oldshop = shop;
		shopRepository.save(oldshop);
	}

}
