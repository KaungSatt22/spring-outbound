package com.outbound.spring_outbound.service;
import com.outbound.spring_outbound.entity.BeneficiaryInfomation;
import com.outbound.spring_outbound.entity.ChildInformation;
import com.outbound.spring_outbound.entity.InsuredPerson;
import com.outbound.spring_outbound.repository.ChildInformationRepository;
import com.outbound.spring_outbound.repository.CountryRepository;
import com.outbound.spring_outbound.repository.InsuredPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InsuredPersonServiceImpl implements InsuredPersonService{

    private InsuredPersonRepository insuredPersonRepository;

    private CountryRepository countryRepository;

    private ChildInformationRepository childInformationRepository;

    @Autowired
    public  InsuredPersonServiceImpl(InsuredPersonRepository insuredPersonRepository,CountryRepository countryRepository,ChildInformationRepository childInformationRepository){
        this.insuredPersonRepository = insuredPersonRepository;
        this.countryRepository = countryRepository;
        this.childInformationRepository = childInformationRepository;
    }

    @Override
    public void createInsuredPerson(InsuredPerson insuredPerson, ChildInformation childInformation, int journeyToId, int destinationCountryId,BeneficiaryInfomation beneficiaryInfomation,boolean isChild) {

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
    }
}
