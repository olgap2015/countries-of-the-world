package com.olgaivancic.countries.controller;

import com.olgaivancic.countries.data.CountryRepository;
import com.olgaivancic.countries.model.Country;
import com.olgaivancic.countries.model.CountryComparatorByPopulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
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

    @RequestMapping(value = "/countries/by-name")
    public String listCountriesSortedByName(ModelMap modelMap) {
        List<Country> countries = new ArrayList<>(countryRepository.findAllCountries());
        countries.sort((c1, c2) -> c1.getName().compareTo(c2.getName()));
        modelMap.put("countries", countries);
        return "sort-by-country-name";
    }


    @RequestMapping(value = "/countries/by-population")
    public String listCountriesSortedByPopulation(ModelMap modelMap) {
        List<Country> countries = new ArrayList<>(countryRepository.findAllCountries());
        // TODO:oi - figure out this method. Maybe need to implement using Comparable interface for Country class
        Collections.sort(countries, new CountryComparatorByPopulation());
        Collections.reverse(countries);
        modelMap.put("countries", countries);
        return "sort-by-country-name";
    }


}
