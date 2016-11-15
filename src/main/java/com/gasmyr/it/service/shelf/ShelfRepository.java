package com.gasmyr.it.service.shelf;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gasmyr.it.model.Shelf;

@Repository
public interface ShelfRepository extends PagingAndSortingRepository<Shelf, Long> {

}
