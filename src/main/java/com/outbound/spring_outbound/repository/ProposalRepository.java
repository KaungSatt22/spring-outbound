package com.outbound.spring_outbound.repository;

import com.outbound.spring_outbound.dto.ProposalDTO;
import com.outbound.spring_outbound.entity.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal,Integer> {

    @Query("SELECT new com.outbound.spring_outbound.dto.ProposalDTO(i.passportNumber, i.passportIssuedCountry.id, i.name, i.contactPhoneNo,i.dateOfBirth ,p.age, p.certificateNumber, p.coveragePlan, p.rates,p.policyStartDate,p.policyEndDate ,p.submittedDate, p.packages, i.countryForDestination.id, i.forChild, a.agentName, ci.childName,ci.dateOfBirth) " +
            "FROM Proposal p " +
            "LEFT JOIN p.insuredPerson i " +
            "LEFT JOIN p.agent a "+
            "LEFT JOIN ChildInformation ci ON ci.insuredPerson.id = i.id " +
            "WHERE i.passportIssuedCountry.id = :passportCountry AND i.passportNumber = :passportNumber")
    List<ProposalDTO> findAllProposals(@Param("passportCountry") int passportCountry, @Param("passportNumber") String passportNumber);

    @Query("SELECT COALESCE(MAX(cast(p.maxValue as int)) , 1) FROM Proposal p")
    int findMaxCertificateNumber();
}
