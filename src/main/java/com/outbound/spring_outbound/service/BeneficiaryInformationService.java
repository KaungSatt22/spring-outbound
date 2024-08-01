package com.outbound.spring_outbound.service;

import com.outbound.spring_outbound.entity.BeneficiaryInfomation;

import java.util.List;


public interface BeneficiaryInformationService {
    BeneficiaryInfomation save(BeneficiaryInfomation beneficiaryInfomation);

    List<BeneficiaryInfomation> getAllBeneficiary();



}
