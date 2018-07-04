package com.olgaivancic.countries.controller;

import com.olgaivancic.countries.data.CountryRepository;
import com.olgaivancic.countries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping(value = "/")
    public String listCountries(ModelMap modelMap) {
        List<Country> countries = countryRepository.findAllCountries();
        modelMap.put("countries", countries);
        return "index";
    }

    @RequestMapping(value = "/country/{slug}")
    public String countryDetails (@PathVariable String slug, ModelMap modelMap) {
        Country country = countryRepository.findBySlug(slug);
        modelMap.put("country", country);
        return "country-detail";
    }

}
