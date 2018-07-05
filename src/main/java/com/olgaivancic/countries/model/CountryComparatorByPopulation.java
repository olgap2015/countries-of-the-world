package com.olgaivancic.countries.model;

import java.util.Comparator;

public class CountryComparatorByPopulation implements Comparator<Country> {
    @Override
    public int compare(Country o1, Country o2) {
        return o1.getPopulation() - o2.getPopulation();
    }
}
