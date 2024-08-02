package com.outbound.spring_outbound.controller;

import com.outbound.spring_outbound.entity.PremiumRates;
import com.outbound.spring_outbound.repository.PremiumRatesRepository;
import com.outbound.spring_outbound.service.PremiumRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin
public class PremiumRatesController {

    @Autowired
    private PremiumRatesService premiumRatesService;

    @GetMapping("/premium")
    public PremiumRates getPremium(@RequestParam int age, @RequestParam int packages, @RequestParam int days) {
        return premiumRatesService.findByPremiumRates(age,packages,days);
    }
}
