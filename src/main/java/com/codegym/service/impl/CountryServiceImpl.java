package com.codegym.service.impl;

import com.codegym.model.Country;
import com.codegym.repository.Countryrepository;
import com.codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryServiceImpl implements CountryService {
    @Autowired
    private Countryrepository countryrepository;
    @Override
    public Iterable<Country> findAll() {
        return countryrepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryrepository.findOne(id);
    }

    @Override
    public void save(Country country) {
        countryrepository.save(country);

    }

    @Override
    public void remove(Long id) {
        countryrepository.delete(id);

    }
}
