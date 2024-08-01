package com.outbound.spring_outbound.service;

import com.outbound.spring_outbound.entity.BeneficiaryInfomation;
import com.outbound.spring_outbound.repository.BeneficiaryInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BeneficiaryInformationServiceImpl implements BeneficiaryInformationService {

    @Autowired
    private BeneficiaryInformationRepository beneficiaryInformationRepository;


    @Override
    @Transactional
    public BeneficiaryInfomation save(BeneficiaryInfomation beneficiaryInfomation) {
        return beneficiaryInformationRepository.save(beneficiaryInfomation);
    }

    @Override
    public List<BeneficiaryInfomation> getAllBeneficiary() {
        return beneficiaryInformationRepository.findAll();
    }


}
