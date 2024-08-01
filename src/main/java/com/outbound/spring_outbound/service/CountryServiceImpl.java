package com.outbound.spring_outbound.service;

import com.outbound.spring_outbound.entity.Country;
import com.outbound.spring_outbound.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> findAllCountry() {
        return countryRepository.findAll();
    }
}
