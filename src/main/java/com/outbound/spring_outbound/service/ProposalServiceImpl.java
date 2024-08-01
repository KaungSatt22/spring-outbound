package com.outbound.spring_outbound.service;

import com.outbound.spring_outbound.entity.Proposal;
import com.outbound.spring_outbound.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProposalServiceImpl implements ProposalService {

    private ProposalRepository proposalRepository;

    @Autowired
    public  ProposalServiceImpl(ProposalRepository proposalRepository){
        this.proposalRepository = proposalRepository;
    }

    @Override
    public void createProposal(Proposal proposal, int insuredPersonId, int agentId) {

    }
}
