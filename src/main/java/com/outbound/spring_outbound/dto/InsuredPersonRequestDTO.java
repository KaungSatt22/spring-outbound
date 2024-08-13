package com.outbound.spring_outbound.dto;

import lombok.Data;
import java.time.LocalDate;


@Data
public class InsuredPersonRequestDTO {

    //InsuredPerson
    private String passportNumber;
    private LocalDate passportIssuedDate;
    private String insuredPersonNRC;
    private String insuredPersonName;
    private LocalDate insuredPersonDOB;
    private String insuredPersonGender;
    private String insuredPersonContactPhoneNo;
    private String foreignContactPhoneNo;
    private String fatherName;
    private String race;
    private String occupation;
    private String maritalStatus;
    private String insuredPersonEmail;
    private String addressInMyanmar;
    private String addressAbroad;
    private boolean forChild;
    private int journeyTo;
    private int countryForDestination;
    private int passportIssuedCountry;

    //Beneficiary
    private String beneficiaryName;
    private LocalDate beneficiaryDOB;
    private String beneficiaryRelationship;
    private String beneficiaryContactPhoneNo;
    private String beneficiaryNRC;
    private String beneficiaryEmail;
    private String beneficiaryAddress;

    //Child
    private String childName;
    private LocalDate childDOB;
    private String childGender;
    private String guardianceName;
    private String childRelationship;

    //proposal
    private String certificateNumber;
    private int coveragePlan;
    private double rates;
    private LocalDate estimatedDepartureDate;
    private LocalDate policyStartDate;
    private double serviceAmount;
    private int insuredPersonAge;
    private int packages;
    private int agentId;



}
