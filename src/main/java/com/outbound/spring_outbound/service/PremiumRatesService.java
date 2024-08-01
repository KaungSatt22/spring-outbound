package com.outbound.spring_outbound.service;

import com.outbound.spring_outbound.entity.PremiumRates;

public interface PremiumRatesService {
    PremiumRates findByPremiumRates(int age, int packages, int days);
}
