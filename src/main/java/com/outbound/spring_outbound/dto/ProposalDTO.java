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

    private Integer passportIssuedCountry;

    private String name;

    private int contactPhone;

    private int age;

    private String certificateNumber;

    private int coveragePlan;

    private double rates;

    private LocalDate submittedDate;

}
