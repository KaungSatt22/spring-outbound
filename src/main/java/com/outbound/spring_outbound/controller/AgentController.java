package com.outbound.spring_outbound.controller;

import com.outbound.spring_outbound.dto.AgentDTO;
import com.outbound.spring_outbound.dto.AssociationDTO;
import com.outbound.spring_outbound.entity.Agent;
import com.outbound.spring_outbound.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin
public class AgentController {
    @Autowired
    private AgentService agentService;


    @PostMapping("/agent")
    public Agent findAgentNameAndLicenseNumber(@ModelAttribute AgentDTO agentDTO){
        return agentService.findByAgentNameAndLicenseNo(agentDTO);
    }

    @PostMapping("/association")
    public Agent findAgentLicenseAndPassword(@ModelAttribute AssociationDTO associationDTO){
        return agentService.FindByAgentLicenseAndPassword(associationDTO);
    }

}
