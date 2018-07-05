package com.olgaivancic.countries.data;

import com.olgaivancic.countries.model.Country;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CountryRepository {

    private static final List<Country> ALL_COUNTRIES = Arrays.asList(
            new Country("Latvia", 1953200, "Riga",
                    new ArrayList<String>() {{
                        add("Latvian");
            }}),
            new Country("Moldova", 2998235, "Chişhinâu",
                    new ArrayList<String>() {{
                        add("Romanian");
            }}),
            new Country("Belarus", 9491800, "Minsk",
                    new ArrayList<String>() {{
                        add("Belarusian");
                        add("Russian");
            }}),
            new Country("United States", 325719178, "Washington, D.C.",
                    new ArrayList<String>() {{
                        add("English");
                    }}),
            new Country("Italy", 60483973, "Rome",
                    new ArrayList<String>() {{
                        add("Italian");
                    }})
    );

    public List<Country> findAllCountries() {
        return ALL_COUNTRIES;
    }

    public Country findBySlug (String slug) {
        return ALL_COUNTRIES.stream()
                .filter(country -> country.getSlug().equals(slug))
                .findFirst()
                .orElseThrow(com.olgaivancic.countries.data.NotFoundException::new);
    }





}
