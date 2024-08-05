package com.outbound.spring_outbound.controller;
import com.outbound.spring_outbound.dto.InsuredPersonRequestDTO;
import com.outbound.spring_outbound.entity.BeneficiaryInfomation;
import com.outbound.spring_outbound.entity.ChildInformation;
import com.outbound.spring_outbound.entity.InsuredPerson;
import com.outbound.spring_outbound.entity.Proposal;
import com.outbound.spring_outbound.service.InsuredPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin
public class InsuredPersonController {

    private InsuredPersonService insuredPersonService;

    @Autowired
    public InsuredPersonController(InsuredPersonService insuredPersonService){
        this.insuredPersonService = insuredPersonService;
    }

    @PostMapping("/insured-person")
    public ResponseEntity<?> createInsuredPerson(@ModelAttribute InsuredPersonRequestDTO insuredPersonRequestDTO){
        insuredPersonService.createInsuredPerson(insuredPersonRequestDTO);
        return ResponseEntity.ok("Created Insured person successfully!");
    }
}
