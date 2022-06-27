package dao;

import entitiy.Country;

import java.util.List;

public interface CountryInterface {
    public List<Country> getCountryById(int id);
}
