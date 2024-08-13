package com.outbound.spring_outbound.service;

import com.outbound.spring_outbound.dto.InsuredPersonRequestDTO;
import com.outbound.spring_outbound.dto.ProposalDTO;
import com.outbound.spring_outbound.entity.BeneficiaryInfomation;
import com.outbound.spring_outbound.entity.ChildInformation;
import com.outbound.spring_outbound.entity.InsuredPerson;
import com.outbound.spring_outbound.entity.Proposal;
import com.outbound.spring_outbound.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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

    @Autowired
    private ChildInformationRepository childInformationRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    @Transactional
    public void createProposal(InsuredPersonRequestDTO insuredPersonRequestDTO) {

        InsuredPerson insuredPerson = new InsuredPerson();
        insuredPerson.setName(insuredPersonRequestDTO.getInsuredPersonName());
        insuredPerson.setDateOfBirth(insuredPersonRequestDTO.getInsuredPersonDOB());
        insuredPerson.setGender(insuredPersonRequestDTO.getInsuredPersonGender());
        insuredPerson.setContactPhoneNo(insuredPersonRequestDTO.getInsuredPersonContactPhoneNo());
        insuredPerson.setForeignContactNo(insuredPersonRequestDTO.getForeignContactPhoneNo());
        insuredPerson.setFatherName(insuredPersonRequestDTO.getFatherName());
        insuredPerson.setRace(insuredPersonRequestDTO.getRace());
        insuredPerson.setOccupation(insuredPersonRequestDTO.getOccupation());
        insuredPerson.setMaritalStatus(insuredPersonRequestDTO.getMaritalStatus());
        insuredPerson.setEmailAddress(insuredPersonRequestDTO.getInsuredPersonEmail());
        insuredPerson.setAddressInMyanmar(insuredPersonRequestDTO.getAddressInMyanmar());
        insuredPerson.setAddressAbroad(insuredPersonRequestDTO.getAddressAbroad());
        insuredPerson.setPassportNumber(insuredPersonRequestDTO.getPassportNumber());
        insuredPerson.setPassportIssuedDate(insuredPersonRequestDTO.getPassportIssuedDate());
        insuredPerson.setNRC(insuredPersonRequestDTO.getInsuredPersonNRC());
        insuredPerson.setForChild(insuredPersonRequestDTO.isForChild());

        countryRepository.findById(insuredPersonRequestDTO.getJourneyTo()).ifPresent(insuredPerson::setJourneyTo);
        countryRepository.findById(insuredPersonRequestDTO.getCountryForDestination()).ifPresent(insuredPerson::setCountryForDestination);
        countryRepository.findById(insuredPersonRequestDTO.getPassportIssuedCountry()).ifPresent(insuredPerson::setPassportIssuedCountry);



        BeneficiaryInfomation beneficiary = new BeneficiaryInfomation();
        beneficiary.setName(insuredPersonRequestDTO.getBeneficiaryName());
        beneficiary.setDateOfBirth(insuredPersonRequestDTO.getBeneficiaryDOB());
        beneficiary.setRelationship(insuredPersonRequestDTO.getBeneficiaryRelationship());
        beneficiary.setContactPhoneNo(insuredPersonRequestDTO.getBeneficiaryContactPhoneNo());
        beneficiary.setNrc(insuredPersonRequestDTO.getBeneficiaryNRC());
        beneficiary.setEmail(insuredPersonRequestDTO.getBeneficiaryEmail());
        beneficiary.setAddress(insuredPersonRequestDTO.getBeneficiaryAddress());
        insuredPerson.setBeneficiaryInfomation(beneficiary);

        insuredPersonRepository.save(insuredPerson);
        if(insuredPersonRequestDTO.isForChild()){
            ChildInformation childInfo = new ChildInformation();
            childInfo.setChildName(insuredPersonRequestDTO.getChildName());
            childInfo.setDateOfBirth(insuredPersonRequestDTO.getChildDOB());
            childInfo.setGender(insuredPersonRequestDTO.getChildGender());
            childInfo.setGuardianceName(insuredPersonRequestDTO.getGuardianceName());
            childInfo.setRelationship(insuredPersonRequestDTO.getChildRelationship());
            childInfo.setInsuredPerson(insuredPerson);
            childInformationRepository.save(childInfo);
        }

        Proposal pro = new Proposal();
        pro.setCertificateNumber(insuredPersonRequestDTO.getCertificateNumber());
        pro.setCoveragePlan(insuredPersonRequestDTO.getCoveragePlan());
        pro.setRates(insuredPersonRequestDTO.getRates());
        pro.setEstimatedDepartureDate(insuredPersonRequestDTO.getEstimatedDepartureDate());
        pro.setPolicyStartDate(insuredPersonRequestDTO.getPolicyStartDate());
        pro.setPolicyEndDate(insuredPersonRequestDTO.getPolicyStartDate().plusDays(insuredPersonRequestDTO.getCoveragePlan()));
        pro.setSubmittedDate(LocalDate.now());
        pro.setServiceAmount(insuredPersonRequestDTO.getServiceAmount());
        pro.setAge(insuredPersonRequestDTO.getInsuredPersonAge());
        pro.setPackages(insuredPersonRequestDTO.getPackages());
        agentRepository.findById(insuredPersonRequestDTO.getAgentId()).ifPresent(pro::setAgent);
        pro.setInsuredPerson(insuredPerson);
        proposalRepository.save(pro);
    }

    @Override
    public List<ProposalDTO> getAllProposals(ProposalDTO proposalDTO) {
        List<ProposalDTO> proposals = proposalRepository.findAllProposals(proposalDTO.getPassportIssuedCountry(),proposalDTO.getPassportNumber());
        return proposals;
    }

}
