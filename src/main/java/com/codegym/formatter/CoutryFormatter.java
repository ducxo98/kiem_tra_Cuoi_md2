package com.codegym.formatter;

import com.codegym.model.Country;
import com.codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CoutryFormatter implements Formatter<Country> {
    private CountryService countryService;
    @Autowired
    public CoutryFormatter(CountryService countryService){
        this.countryService = countryService;
    }
    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        return countryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Country object, Locale locale) {
        return "["+object.getId()+","+object.getName()+"]";
    }
}
