package com.outbound.spring_outbound.dto;
import lombok.*;
import java.time.LocalDate;


@Getter
@Setter
@ToString
public class ProposalDTO {
    private String passportNumber;

    private int passportIssuedCountry;

    private String name;

    private String contactPhone;

    private LocalDate DOB;

    private int age;

    private String certificateNumber;

    private int coveragePlan;

    private double rates;

    private LocalDate policyStartDate;

    private LocalDate policyEndDate;

    private LocalDate submittedDate;

    private int packages;

    private int destinationTo;

    private boolean forChild;

    private String agentName;

    private String childName;

    private LocalDate childDOB;

    public ProposalDTO(){}

    public ProposalDTO(String passportNumber, int passportIssuedCountry, String name, String contactPhone,LocalDate DOB, int age,
                       String certificateNumber, int coveragePlan, double rates,LocalDate policyStartDate,LocalDate policyEndDate,  LocalDate submittedDate, int packages,
                       int destinationTo, boolean forChild,String agentName,String childName,LocalDate childDOB) {
        this.passportNumber = passportNumber;
        this.passportIssuedCountry = passportIssuedCountry;
        this.name = name;
        this.contactPhone = contactPhone;
        this.DOB = DOB;
        this.age = age;
        this.certificateNumber = certificateNumber;
        this.coveragePlan = coveragePlan;
        this.rates = rates;
        this.policyStartDate = policyStartDate;
        this.policyEndDate = policyEndDate;
        this.submittedDate = submittedDate;
        this.packages = packages;
        this.destinationTo = destinationTo;
        this.forChild = forChild;
        this.agentName = agentName;
        this.childName = childName;
        this.childDOB = childDOB;
    }
}
