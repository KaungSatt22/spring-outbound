package com.outbound.spring_outbound.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProposalDTO {
    private String passportNumber;

    private int passportIssuedCountry;

    private String name;

    private String contactPhone;

    private int age;

    private String certificateNumber;

    private int coveragePlan;

    private double rates;

    private LocalDate submittedDate;

    private int packages;

    private int destinationTo;

    private boolean forChild;

    private String agentName;

}
