package com.outbound.spring_outbound.service;

import com.outbound.spring_outbound.entity.PremiumRates;
import com.outbound.spring_outbound.repository.PremiumRatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremiumRatesServiceImpl implements PremiumRatesService{
    @Autowired
    private PremiumRatesRepository premiumRatesRepository;

    @Override
    public PremiumRates findByPremiumRates(int age, int packages, int days) {
        return premiumRatesRepository.findPremiumRatesBy(age,packages,days);
    }
}
