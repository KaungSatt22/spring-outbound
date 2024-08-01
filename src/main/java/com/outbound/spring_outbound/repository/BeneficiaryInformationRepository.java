package com.outbound.spring_outbound.repository;

import com.outbound.spring_outbound.entity.BeneficiaryInfomation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryInformationRepository extends JpaRepository<BeneficiaryInfomation, Integer> {

}
