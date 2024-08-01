package com.outbound.spring_outbound.repository;

import com.outbound.spring_outbound.entity.PremiumRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiumRatesRepository extends JpaRepository<PremiumRates, Integer> {
    @Query("SELECT p FROM PremiumRates p WHERE p.fromAge <= :age AND p.toAge >= :age AND p.packages = :packages AND p.numberOfDays = :days")
    PremiumRates findPremiumRatesBy(@Param("age") int age, @Param("packages") int packages, @Param("days") int days);
}