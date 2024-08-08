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

    @Query("SELECT new com.outbound.spring_outbound.dto.ProposalDTO(i.passportNumber,i.passportIssuedCountry.id, i.name,i.contactPhoneNo,p.age,p.certificateNumber,p.coveragePlan,p.rates,p.submittedDate,p.packages,i.countryForDestination.id,i.forChild,p.agent.agentName) FROM InsuredPerson i JOIN Proposal p ON  i.id= p.id and i.passportIssuedCountry.id=:passportCountry and i.passportNumber=:passportNumber")
    List<ProposalDTO> findAllProposals(@Param("passportCountry") int passportCountry, @Param("passportNumber") String passportNumber);
}
