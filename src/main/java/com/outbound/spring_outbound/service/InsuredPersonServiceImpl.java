package com.outbound.spring_outbound.service;
import com.outbound.spring_outbound.entity.BeneficiaryInfomation;
import com.outbound.spring_outbound.entity.ChildInformation;
import com.outbound.spring_outbound.entity.InsuredPerson;
import com.outbound.spring_outbound.entity.Proposal;
import com.outbound.spring_outbound.repository.ChildInformationRepository;
import com.outbound.spring_outbound.repository.CountryRepository;
import com.outbound.spring_outbound.repository.InsuredPersonRepository;
import com.outbound.spring_outbound.repository.ProposalRepository;
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

    @Autowired
    public  InsuredPersonServiceImpl(InsuredPersonRepository insuredPersonRepository,CountryRepository countryRepository,ChildInformationRepository childInformationRepository,ProposalRepository proposalRepository){
        this.insuredPersonRepository = insuredPersonRepository;
        this.countryRepository = countryRepository;
        this.childInformationRepository = childInformationRepository;
        this.proposalRepository = proposalRepository;
    }

    @Override
    public void createInsuredPerson(InsuredPerson insuredPerson, ChildInformation childInformation, int journeyToId, int destinationCountryId,BeneficiaryInfomation beneficiaryInfomation,boolean isChild,Proposal proposal) {

        countryRepository.findById(journeyToId).ifPresent(insuredPerson::setJourneyTo);

        countryRepository.findById(destinationCountryId).ifPresent(insuredPerson::setCountryForDestination);

        BeneficiaryInfomation beneficiary = new BeneficiaryInfomation();
        beneficiary.setName(beneficiaryInfomation.getName());
        beneficiary.setDateOfBirth(beneficiaryInfomation.getDateOfBirth());
        beneficiary.setRelationship(beneficiaryInfomation.getRelationship());
        beneficiary.setContactPhoneNo(beneficiaryInfomation.getContactPhoneNo());
        beneficiary.setNrc(beneficiaryInfomation.getNrc());
        beneficiary.setEmail(beneficiaryInfomation.getEmail());
        beneficiary.setAddress(beneficiaryInfomation.getAddress());
        insuredPerson.setBeneficiaryInfomation(beneficiary);
        insuredPerson.setChild(isChild);
        insuredPersonRepository.save(insuredPerson);
        if(isChild){
            ChildInformation childInfo = new ChildInformation();
            childInfo.setChildName(childInformation.getChildName());
            childInfo.setDateOfBirth(childInformation.getDateOfBirth());
            childInfo.setGender(childInformation.getGender());
            childInfo.setGuardianceName(childInformation.getGuardianceName());
            childInfo.setRelationship(childInformation.getRelationship());
            childInfo.setInsuredPerson(insuredPerson);
            childInformationRepository.save(childInfo);
        }

        Proposal pro = new Proposal();
        pro.setCertificateNumber(proposal.getCertificateNumber());
        pro.setCoveragePlan(proposal.getCoveragePlan());
        pro.setRates(proposal.getRates());
        pro.setEstimatedDepartureDate(proposal.getEstimatedDepartureDate());
        pro.setPolicyStartDate(proposal.getPolicyStartDate());
        pro.setPolicyEndDate(proposal.getPolicyStartDate().plusDays(proposal.getCoveragePlan()));
        pro.setSubmittedDate(LocalDate.now());
        pro.setServiceAmount(proposal.getServiceAmount());
        pro.setAge(proposal.getAge());
        pro.setPackages(proposal.getPackages());
        pro.setInsuredPerson(proposal.getInsuredPerson());
        pro.setAgent(proposal.getAgent());
        pro.setInsuredPerson(insuredPerson);
        proposalRepository.save(pro);
    }
}
