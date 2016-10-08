package com.gasmyr.it.service.shop;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gasmyr.it.model.Shop;

@Repository
public interface ShopRepository extends PagingAndSortingRepository<Shop, Long> {

}
