package com.outbound.spring_outbound.service;

import com.outbound.spring_outbound.dto.AssociationDTO;
import com.outbound.spring_outbound.entity.Agent;

public interface AssociationService {
    Agent FindByAgentLicenseAndPassword(AssociationDTO associationDTO);
}
