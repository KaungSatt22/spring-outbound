package com.outbound.spring_outbound.service;

import com.outbound.spring_outbound.dto.ProposalDTO;
import com.outbound.spring_outbound.entity.InsuredPerson;
import com.outbound.spring_outbound.entity.Proposal;
import com.outbound.spring_outbound.repository.AgentRepository;
import com.outbound.spring_outbound.repository.InsuredPersonRepository;
import com.outbound.spring_outbound.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProposalServiceImpl implements ProposalService {

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private InsuredPersonRepository insuredPersonRepository;

    @Autowired
    private AgentRepository agentRepository;


    @Override
    public void createProposal(Proposal proposal, int insuredPersonId, int agentId) {
        insuredPersonRepository.findById(insuredPersonId).ifPresent(proposal::setInsuredPerson);

        agentRepository.findById(agentId).ifPresent(proposal::setAgent);

        proposalRepository.save(proposal);

    }

    @Override
    public List<ProposalDTO> getAllProposals(ProposalDTO proposalDTO) {
        List<ProposalDTO> proposals = proposalRepository.findAllProposals(proposalDTO.getPassportIssuedCountry(),proposalDTO.getPassportNumber());
        return proposals;
    }

}
