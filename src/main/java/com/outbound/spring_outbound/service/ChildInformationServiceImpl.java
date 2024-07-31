package com.outbound.spring_outbound.service;

import com.outbound.spring_outbound.entity.ChildInformation;
import com.outbound.spring_outbound.entity.InsuredPerson;
import com.outbound.spring_outbound.repository.ChildInformationRepository;
import com.outbound.spring_outbound.repository.InsuredPersonRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildInformationServiceImpl implements  ChildInformationService{

    private ChildInformationRepository childInformationRepository;


    @Autowired
    public ChildInformationServiceImpl(ChildInformationRepository childInformationRepository){
        this.childInformationRepository = childInformationRepository;

    }


    @Override
    public ChildInformation saveChildInformation(ChildInformation childInformation) {
        return childInformationRepository.save(childInformation);
    }
}
