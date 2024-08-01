package com.outbound.spring_outbound.repository;

import com.outbound.spring_outbound.entity.BeneficiaryInfomation;
import com.outbound.spring_outbound.entity.Country;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryInformationRepository extends JpaRepository<BeneficiaryInfomation, Integer> {
    @Query(value = "select b from BeneficiaryInfomation b where b.id =:id")
    BeneficiaryInfomation getBeneficiaryInformationById(@Param("id") int id);
}
