package com.outbound.spring_outbound.service;


import com.outbound.spring_outbound.dto.AssociationDTO;
import com.outbound.spring_outbound.entity.Agent;
import com.outbound.spring_outbound.repository.AssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociationServiceImpl implements AssociationService{

    @Autowired
    private AssociationRepository associationRepository;


    @Override
    public Agent FindByAgentLicenseAndPassword(AssociationDTO associationDTO) {
        return associationRepository.FindAgentByAssociation(associationDTO.getAgentLicenseNumber(),associationDTO.getPassword());
    }
}
