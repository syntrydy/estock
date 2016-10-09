package com.gasmyr.it.service.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gasmyr.it.model.Location;
@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void add(Location location) {
		locationRepository.save(location);

	}

	@Override
	public int delete(Location location) {
		if (location != null) {
			locationRepository.delete(location);
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public int deleteById(Long id) {
		if (id == null) {
			return -1;
		} else {
			locationRepository.delete(id);
			return 1;
		}
	}

	@Override
	public void update(Long id, Location location) {
		System.out.println("===============================++++++++>");
		System.out.println(location);
		System.out.println("===============================++++++++>");
		Location oldLocation = locationRepository.findOne(id);
		if (oldLocation != null) {
			oldLocation.update(location);
			System.out.println(oldLocation);
			System.out.println("===============================++++++++>");
			locationRepository.save(oldLocation);
		}

	}

	@Override
	public Location findById(Long id) {
		return locationRepository.findOne(id);
	}

	@Override
	public List<Location> findAll() {
		return (List<Location>) locationRepository.findAll();
	}

	@Override
	public Page<Location> findAllByPage(Pageable page) {
		return locationRepository.findAll(page);
	}

}
