package com.outbound.spring_outbound.service;

import com.outbound.spring_outbound.entity.Country;

import java.util.List;

public interface CountryService {
        Country createCountry(Country country);

        List<Country> findAllCountry();
}
