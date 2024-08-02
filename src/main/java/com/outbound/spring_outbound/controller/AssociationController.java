package com.outbound.spring_outbound.controller;

import com.outbound.spring_outbound.dto.AssociationDTO;
import com.outbound.spring_outbound.entity.Agent;
import com.outbound.spring_outbound.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin
public class AssociationController {
    @Autowired
    private AssociationService associationService;

    @PostMapping("/association")
    public Agent findAgentLicenseAndPassword(@ModelAttribute AssociationDTO associationDTO){
        return associationService.FindByAgentLicenseAndPassword(associationDTO);
    }
}
