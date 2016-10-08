package com.gasmyr.it.service.location;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gasmyr.it.model.Location;

public interface LocationService {
	
	void add(Location location);

	int delete(Location location);

	int deleteById(Long id);
	
	void update(Long id,Location location);

	Location findById(Long id);

	List<Location> findAll();
	
	Page<Location> findAllByPage(Pageable page);

}
