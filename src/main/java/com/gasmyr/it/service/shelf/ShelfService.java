package com.gasmyr.it.service.shelf;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gasmyr.it.model.Shelf;

public interface ShelfService{
	
	void add(Shelf shelf);

	void delete(Shelf shelf);

	int deleteById(Long id);
	
	void update(Long id,Shelf shelf);

	Shelf findById(Long id);

	List<Shelf> findAll();
	
	Page<Shelf> findAllByPage(Pageable page);

}
