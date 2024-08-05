package com.outbound.spring_outbound.dto;

import com.outbound.spring_outbound.entity.BeneficiaryInfomation;
import com.outbound.spring_outbound.entity.ChildInformation;
import com.outbound.spring_outbound.entity.InsuredPerson;
import com.outbound.spring_outbound.entity.Proposal;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InsuredPersonRequestDTO {

    private InsuredPerson insuredPerson;
    private ChildInformation childInformation;
    private BeneficiaryInfomation beneficiaryInfomation;
    private Proposal proposal;
    private int journeyToId;
    private int destinationCountryId;
    private int passportIssuedCountryId;
    private String beneficiaryName;
    private LocalDate beneficiaryDOB;
    private int beneficiaryPhoneNo;
    private LocalDate childDOB;
    private String childGender;
    private String childRelationship;
    private int agentId;

}
