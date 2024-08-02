package com.outbound.spring_outbound.service;

import com.outbound.spring_outbound.entity.Proposal;

public interface ProposalService {
    void createProposal(Proposal proposal,int insuredPersonId,int agentId);


}
