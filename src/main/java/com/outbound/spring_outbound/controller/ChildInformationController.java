package com.outbound.spring_outbound.controller;
import com.outbound.spring_outbound.entity.ChildInformation;
import com.outbound.spring_outbound.service.ChildInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin
public class ChildInformationController {

    private ChildInformationService childInformationService;

    @Autowired
    public ChildInformationController(ChildInformationService childInformationService){
        this.childInformationService = childInformationService;
    }

    @PostMapping("/child")
    public ResponseEntity<?> createChildInformation(@ModelAttribute ChildInformation childInformation){
        ChildInformation childInfo = childInformationService.saveChildInformation(childInformation);
        return ResponseEntity.ok("Created Child Information Successfully!");
    }
}
