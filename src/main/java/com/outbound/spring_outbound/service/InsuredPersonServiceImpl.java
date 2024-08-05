package com.outbound.spring_outbound.service;
import com.outbound.spring_outbound.dto.InsuredPersonRequestDTO;
import com.outbound.spring_outbound.entity.BeneficiaryInfomation;
import com.outbound.spring_outbound.entity.ChildInformation;
import com.outbound.spring_outbound.entity.InsuredPerson;
import com.outbound.spring_outbound.entity.Proposal;
import com.outbound.spring_outbound.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InsuredPersonServiceImpl implements InsuredPersonService{

    private InsuredPersonRepository insuredPersonRepository;

    private CountryRepository countryRepository;

    private ChildInformationRepository childInformationRepository;

    private ProposalRepository proposalRepository;

    private AgentRepository agentRepository;

    @Autowired
    public  InsuredPersonServiceImpl(InsuredPersonRepository insuredPersonRepository,CountryRepository countryRepository,ChildInformationRepository childInformationRepository,ProposalRepository proposalRepository,AgentRepository agentRepository){
        this.insuredPersonRepository = insuredPersonRepository;
        this.countryRepository = countryRepository;
        this.childInformationRepository = childInformationRepository;
        this.proposalRepository = proposalRepository;
        this.agentRepository = agentRepository;
    }

    @Override
    public void createInsuredPerson(InsuredPersonRequestDTO insuredPersonRequestDTO) {

        countryRepository.findById(insuredPersonRequestDTO.getJourneyToId()).ifPresent(insuredPersonRequestDTO.getInsuredPerson()::setJourneyTo);

        countryRepository.findById(insuredPersonRequestDTO.getDestinationCountryId()).ifPresent(insuredPersonRequestDTO.getInsuredPerson()::setCountryForDestination);

        countryRepository.findById(insuredPersonRequestDTO.getPassportIssuedCountryId()).ifPresent(insuredPersonRequestDTO.getInsuredPerson()::setPassportIssuedCountry);

        BeneficiaryInfomation beneficiary = new BeneficiaryInfomation();
        beneficiary.setName(insuredPersonRequestDTO.getBeneficiaryName());
        beneficiary.setDateOfBirth(insuredPersonRequestDTO.getBeneficiaryDOB());
        beneficiary.setRelationship(insuredPersonRequestDTO.getBeneficiaryInfomation().getRelationship());
        beneficiary.setContactPhoneNo(insuredPersonRequestDTO.getBeneficiaryPhoneNo());
        beneficiary.setNrc(insuredPersonRequestDTO.getBeneficiaryInfomation().getNrc());
        beneficiary.setEmail(insuredPersonRequestDTO.getBeneficiaryInfomation().getEmail());
        beneficiary.setAddress(insuredPersonRequestDTO.getBeneficiaryInfomation().getAddress());
        insuredPersonRequestDTO.getInsuredPerson().setBeneficiaryInfomation(beneficiary);
        insuredPersonRequestDTO.getInsuredPerson().setForChild(insuredPersonRequestDTO.getInsuredPerson().isForChild());
        insuredPersonRepository.save(insuredPersonRequestDTO.getInsuredPerson());
        if(insuredPersonRequestDTO.getInsuredPerson().isForChild()){
            ChildInformation childInfo = new ChildInformation();
            childInfo.setChildName(insuredPersonRequestDTO.getChildInformation().getChildName());
            childInfo.setDateOfBirth(insuredPersonRequestDTO.getChildDOB());
            childInfo.setGender(insuredPersonRequestDTO.getChildGender());
            childInfo.setGuardianceName(insuredPersonRequestDTO.getChildInformation().getGuardianceName());
            childInfo.setRelationship(insuredPersonRequestDTO.getChildRelationship());
            childInfo.setInsuredPerson(insuredPersonRequestDTO.getInsuredPerson());
            childInformationRepository.save(childInfo);
        }

        Proposal pro = new Proposal();
        pro.setCertificateNumber(insuredPersonRequestDTO.getProposal().getCertificateNumber());
        pro.setCoveragePlan(insuredPersonRequestDTO.getProposal().getCoveragePlan());
        pro.setRates(insuredPersonRequestDTO.getProposal().getRates());
        pro.setEstimatedDepartureDate(insuredPersonRequestDTO.getProposal().getEstimatedDepartureDate());
        pro.setPolicyStartDate(insuredPersonRequestDTO.getProposal().getPolicyStartDate());
        pro.setPolicyEndDate(insuredPersonRequestDTO.getProposal().getPolicyStartDate().plusDays(insuredPersonRequestDTO.getProposal().getCoveragePlan()));
        pro.setSubmittedDate(LocalDate.now());
        pro.setServiceAmount(insuredPersonRequestDTO.getProposal().getServiceAmount());
        pro.setAge(insuredPersonRequestDTO.getProposal().getAge());
        pro.setPackages(insuredPersonRequestDTO.getProposal().getPackages());
        agentRepository.findById(insuredPersonRequestDTO.getAgentId()).ifPresent(pro::setAgent);
        pro.setInsuredPerson(insuredPersonRequestDTO.getInsuredPerson());
        proposalRepository.save(pro);
    }
}
