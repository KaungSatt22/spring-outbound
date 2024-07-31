package com.outbound.spring_outbound.repository;

import com.outbound.spring_outbound.entity.InsuredPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuredPersonRepository extends JpaRepository<InsuredPerson,Integer> {
}
