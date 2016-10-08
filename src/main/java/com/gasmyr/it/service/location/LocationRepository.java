package com.gasmyr.it.service.location;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gasmyr.it.model.Location;
@Repository
public interface LocationRepository extends PagingAndSortingRepository<Location, Long>{

}
