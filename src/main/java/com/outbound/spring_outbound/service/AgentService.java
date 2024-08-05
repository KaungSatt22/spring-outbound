package com.outbound.spring_outbound.service;

import com.outbound.spring_outbound.dto.AgentDTO;
import com.outbound.spring_outbound.dto.AssociationDTO;
import com.outbound.spring_outbound.entity.Agent;

public interface AgentService {
    Agent findByAgentNameAndLicenseNo(AgentDTO agentDTO);

    Agent FindByAgentLicenseAndPassword(AssociationDTO associationDTO);
}
