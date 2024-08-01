package com.outbound.spring_outbound.controller;

import com.outbound.spring_outbound.dto.AgentDTO;
import com.outbound.spring_outbound.entity.Agent;
import com.outbound.spring_outbound.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class AgentController {
    @Autowired
    private AgentService agentService;

    @PostMapping("/agent")
    public Agent findAgentNameAndLicenseNumber(@ModelAttribute AgentDTO agentDTO){
            return agentService.findByAgentNameAndLicenseNo(agentDTO);

    }

}
