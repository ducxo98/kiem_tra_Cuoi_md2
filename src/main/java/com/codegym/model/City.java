package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String name;
    @DecimalMin("0.1")
    private Double acreage;
    @DecimalMin("0.1")
    private Double population;
    @DecimalMin("0.1")
    private Double GDP;
    @NotEmpty
    private String detail;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public void setCountry(Country country) {
        this.country = country;
    }

    public City() {
    }

    public City(String name, Double acreage, Double population, Double GDP, String detail) {
        this.name = name;
        this.acreage = acreage;
        this.population = population;
        this.GDP = GDP;
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public Double getAcreage() {
        return acreage;
    }

    public void setAcreage(Double acreage) {
        this.acreage = acreage;
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

    public Double getGDP() {
        return GDP;
    }

    public void setGDP(Double GDP) {
        this.GDP = GDP;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
