package com.flightticketbooking.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Airport {
    private String name;
    private String city;
    private String country;
    private String time;
    public Airport(){}
    public Airport(String name, String city, String country, String time) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.time = time;
    }
    @JsonProperty("name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("city")
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return name.equalsIgnoreCase(airport.name) && city.equalsIgnoreCase(airport.city) && country.equalsIgnoreCase(airport.country) && time.equalsIgnoreCase(airport.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, country, time);
    }
    public void update(Airport airport){
        if(!airport.getName().equalsIgnoreCase("None")){
            this.setName(airport.getName());
        }
        if(!airport.getCity().equalsIgnoreCase("None")){
            this.setCity(airport.getCity());
        }
        if(!airport.getCity().equalsIgnoreCase("None")){
            this.setCountry(airport.getCountry());
        }
        if(!airport.getTime().equalsIgnoreCase("None")){
            this.setCountry(airport.getTime());
        }
    }
}
