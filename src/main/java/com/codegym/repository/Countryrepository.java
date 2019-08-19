package com.codegym.repository;

import com.codegym.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Countryrepository extends PagingAndSortingRepository<Country,Long> {
}
