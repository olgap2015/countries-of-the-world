package com.olgaivancic.countries.model;

import com.github.slugify.Slugify;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

public class Country {

    private String name;
    private String slug;
    private int population;
    private String formattedPopulation;
    private String capitalCity;
    List<String> languages;

    public Country(String name, int population, String capitalCity, List<String> languages) {
        this.name = name;
        try {
            Slugify slugify = new Slugify();
            slug = slugify.slugify(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.population = population;
        formattedPopulation = formatPopulation();
        this.capitalCity = capitalCity;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getSlug() {
        return slug;
    }

    public String getFormattedPopulation() {
        return formattedPopulation;
    }

    private String formatPopulation() {
        NumberFormat numberformat = NumberFormat.getNumberInstance(Locale.US);
        if (numberformat instanceof DecimalFormat) {
            DecimalFormat decimalFormat = (DecimalFormat) numberformat;
            decimalFormat.applyPattern("#");
            decimalFormat.setGroupingUsed(true);
            decimalFormat.setGroupingSize(3);
            return decimalFormat.format(population);
        }
        return null;
    }


}
