package com.outbound.spring_outbound.controller;


import com.outbound.spring_outbound.entity.BeneficiaryInfomation;
import com.outbound.spring_outbound.repository.BeneficiaryInformationRepository;
import com.outbound.spring_outbound.service.BeneficiaryInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin
public class BeneficiaryInformationController {
    @Autowired
    private BeneficiaryInformationService beneficiaryInformationService;


    @PostMapping("/beneficiary")
    public ResponseEntity<String> createBeneficiary(@ModelAttribute BeneficiaryInfomation beneficiaryInfomation){
            beneficiaryInformationService.save(beneficiaryInfomation);
            return ResponseEntity.ok("Beneficiary Created");
    }

    @GetMapping("/beneficiary")
    public List<BeneficiaryInfomation> getAllBeneficiary(){
        return beneficiaryInformationService.getAllBeneficiary();
    }
}
