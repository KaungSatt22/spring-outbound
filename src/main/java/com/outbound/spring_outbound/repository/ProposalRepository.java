package com.outbound.spring_outbound.repository;

import com.outbound.spring_outbound.entity.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal,Integer> {


}
