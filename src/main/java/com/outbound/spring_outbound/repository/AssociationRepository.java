package com.outbound.spring_outbound.repository;

import com.outbound.spring_outbound.entity.Agent;
import com.sun.nio.sctp.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationRepository extends JpaRepository<Agent , Integer> {
    @Query("SELECT a FROM Agent a WHERE a.agentLicenseNumber = :agentLicenseNumber and a.password = :password and a.agentType='association'")
    Agent FindAgentByAssociation(@Param("agentLicenseNumber")String agentLicenseNumber,@Param("password")String password);

}
