package com.api.infrastructure.repository.jpa;

import com.api.infrastructure.entity.OTPEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringJPAOTPRepository  extends JpaRepository<OTPEntity, Long> {
    Optional<OTPEntity> findTopByEmailIdOrderByIdDesc(String emailId);
}
