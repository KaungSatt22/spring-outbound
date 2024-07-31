package com.outbound.spring_outbound.repository;

import com.outbound.spring_outbound.entity.ChildInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildInformationRepository extends JpaRepository<ChildInformation,Integer>{

}
