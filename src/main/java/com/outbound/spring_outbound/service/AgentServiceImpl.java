package com.outbound.spring_outbound.service;

import com.outbound.spring_outbound.dto.AgentDTO;
import com.outbound.spring_outbound.dto.AssociationDTO;
import com.outbound.spring_outbound.entity.Agent;
import com.outbound.spring_outbound.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentServiceImpl implements AgentService{
    @Autowired
    private AgentRepository agentRepository;


    @Override
    public Agent findByAgentNameAndLicenseNo(AgentDTO agentDTO) {
        return agentRepository.FindAgentByAgentName(agentDTO.getAgentName(), agentDTO.getAgentLicenseNumber());
    }

    @Override
    public Agent FindByAgentLicenseAndPassword(AssociationDTO associationDTO) {
        return agentRepository.FindAgentByAssociation(associationDTO.getAgentLicenseNumber(),associationDTO.getPassword());
    }
}
