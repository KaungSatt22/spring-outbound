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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public int getCoveragePlan() {
        return coveragePlan;
    }

    public void setCoveragePlan(int coveragePlan) {
        this.coveragePlan = coveragePlan;
    }

    public double getRates() {
        return rates;
    }

    public void setRates(double rates) {
        this.rates = rates;
    }

    public LocalDate getEstimatedDepartureDate() {
        return estimatedDepartureDate;
    }

    public void setEstimatedDepartureDate(LocalDate estimatedDepartureDate) {
        this.estimatedDepartureDate = estimatedDepartureDate;
    }

    public LocalDate getPolicyStartDate() {
        return policyStartDate;
    }

    public void setPolicyStartDate(LocalDate policyStartDate) {
        this.policyStartDate = policyStartDate;
    }

    public LocalDate getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(LocalDate policyEndDate) {
        this.policyEndDate = policyEndDate;
    }

    public LocalDate getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(LocalDate submittedDate) {
        this.submittedDate = submittedDate;
    }

    public double getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(double serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPackages() {
        return packages;
    }

    public void setPackages(int packages) {
        this.packages = packages;
    }

    public InsuredPerson getInsuredPerson() {
        return insuredPerson;
    }

    public void setInsuredPerson(InsuredPerson insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}
