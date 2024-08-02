package com.outbound.spring_outbound.service;

import com.outbound.spring_outbound.entity.BeneficiaryInfomation;
import com.outbound.spring_outbound.entity.ChildInformation;
import com.outbound.spring_outbound.entity.InsuredPerson;
import com.outbound.spring_outbound.entity.Proposal;

import java.util.List;

public interface InsuredPersonService {

    void createInsuredPerson(InsuredPerson insuredPerson, ChildInformation childInformation, int journeyToId, int destinationCountryId, BeneficiaryInfomation beneficiaryInfomation, boolean isChild, Proposal proposal);

}
