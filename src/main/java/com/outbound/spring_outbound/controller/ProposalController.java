package com.outbound.spring_outbound.controller;

import com.outbound.spring_outbound.dto.InsuredPersonRequestDTO;
import com.outbound.spring_outbound.dto.ProposalDTO;
import com.outbound.spring_outbound.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProposalController {

    @Autowired
    private ProposalService proposalService;

    @PostMapping("/enquiry")
    public List<ProposalDTO> findAll(@ModelAttribute ProposalDTO proposalDTO) {
        return proposalService.getAllProposals(proposalDTO);
    }


    @PostMapping("/proposal")
    public ResponseEntity<?> createProposal(@ModelAttribute InsuredPersonRequestDTO insuredPersonRequestDTO){
        proposalService.createProposal(insuredPersonRequestDTO);
        return ResponseEntity.ok("Created Insured person successfully!");
    }
}
