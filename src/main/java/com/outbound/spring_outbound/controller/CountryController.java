package com.outbound.spring_outbound.controller;


import com.outbound.spring_outbound.entity.Country;
import com.outbound.spring_outbound.repository.CountryRepository;
import com.outbound.spring_outbound.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    private  List<Country> getAllCountries() {
        return countryService.findAllCountry();
    }


}
