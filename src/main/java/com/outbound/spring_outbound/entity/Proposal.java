package com.outbound.spring_outbound.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proposal")
public class Proposal extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "certificate_number")
    private String certificateNumber;

    @Column(name = "coverage_plan")
    private int coveragePlan;

    @Column(name = "rates")
    private double rates;

    @Column(name = "estimated_departure_date")
    private LocalDate estimatedDepartureDate;

    @Column(name = "policy_start_date")
    private LocalDate policyStartDate;

    @Column(name = "policy_end_date")
    private LocalDate policyEndDate;

    @Column(name = "submitted_date")
    private LocalDate submittedDate;

    @Column(name = "service_amount")
    private double serviceAmount;

    @Column(name = "age")
    private int age;

    @Column(name = "packages")
    private int packages;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "insuredPerson_id")
    private InsuredPerson insuredPerson;

    @ManyToOne(cascade = {
            CascadeType.DETACH,  CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH
    })
    @JoinColumn(name = "agent_id")
    private Agent agent;

}
