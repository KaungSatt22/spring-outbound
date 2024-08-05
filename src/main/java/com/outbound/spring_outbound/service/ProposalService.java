package com.outbound.spring_outbound.service;

import com.outbound.spring_outbound.dto.ProposalDTO;
import com.outbound.spring_outbound.entity.Proposal;

import java.util.List;

public interface ProposalService {
    void createProposal(Proposal proposal,int insuredPersonId,int agentId);

    List<ProposalDTO> getAllProposals(ProposalDTO proposalDTO);
}
