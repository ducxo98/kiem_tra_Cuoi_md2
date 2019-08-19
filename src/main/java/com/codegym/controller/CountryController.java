package com.codegym.controller;

import com.codegym.model.Country;
import com.codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;
    @GetMapping("/countries")
    public ModelAndView listCountry(){
        Iterable<Country>countries = countryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/country/list");
        modelAndView.addObject("countries",countries);
        return modelAndView;
    }
    @GetMapping("/create-country")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/country/create");
        modelAndView.addObject("country",new Country());
        return modelAndView;
    }
    @PostMapping("/create-country")
    public ModelAndView saveCountry(@ModelAttribute("country")Country country){
        countryService.save(country);
        ModelAndView modelAndView = new ModelAndView("/country/create");
        modelAndView.addObject("country",new Country());
        modelAndView.addObject("message","New country created successfully");
        return modelAndView;
    }
    @GetMapping("/edit-country/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Country country = countryService.findById(id);
        if(country != null) {
            ModelAndView modelAndView = new ModelAndView("/country/edit");
            modelAndView.addObject("country", country);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-country")
    public ModelAndView updateCountry(@ModelAttribute("country") Country country){
        countryService.save(country);
        ModelAndView modelAndView = new ModelAndView("/country/edit");
        modelAndView.addObject("country", country);
        modelAndView.addObject("message", "Country updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-country/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Country country = countryService.findById(id);
        if(country != null) {
            ModelAndView modelAndView = new ModelAndView("/country/delete");
            modelAndView.addObject("country", country);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-country")
    public String deleteCustomer(@ModelAttribute("country") Country country){
        countryService.remove(country.getId());
        return "redirect:countries";
    }
}
