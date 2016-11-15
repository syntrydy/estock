package com.gasmyr.it.service.shelf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gasmyr.it.model.Shelf;

@Service
public class ShelfServiceImpl implements ShelfService {

	@Autowired
	ShelfRepository shelfRepository;

	@Override
	public void add(Shelf shelf) {
		shelfRepository.save(shelf);
	}

	@Override
	public void delete(Shelf shelf) {
		shelfRepository.delete(shelf);
	}

	@Override
	public int deleteById(Long id) {
		if (id != null) {
			shelfRepository.delete(id);
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public void update(Long id, Shelf shelf) {
		Shelf oldShelf = shelfRepository.findOne(id);
		oldShelf.update(shelf);
		shelfRepository.save(oldShelf);

	}

	@Override
	public Shelf findById(Long id) {
		return shelfRepository.findOne(id);
	}

	@Override
	public List<Shelf> findAll() {
		return (List<Shelf>) shelfRepository.findAll(new Sort("id"));
	}

	@Override
	public Page<Shelf> findAllByPage(Pageable page) {
		return shelfRepository.findAll(page);
	}

}
