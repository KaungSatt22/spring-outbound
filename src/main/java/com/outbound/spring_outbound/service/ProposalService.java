package com.outbound.spring_outbound.service;

import com.outbound.spring_outbound.dto.InsuredPersonRequestDTO;
import com.outbound.spring_outbound.dto.ProposalDTO;
import com.outbound.spring_outbound.entity.Proposal;

import java.util.List;

public interface ProposalService {

    List<ProposalDTO> getAllProposals(ProposalDTO proposalDTO);

    void createProposal(InsuredPersonRequestDTO insuredPersonRequestDTO);
}
