package com.codegym.service;

import com.codegym.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {
//    Iterable<City>findAllByDepart(Department department);
    Page<City> findAll(Pageable pageable);
    City findById(Long id);
    void save(City city);
    void remove(Long id);
}
