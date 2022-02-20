package com.api.infrastructure.repository.jpa;

import com.api.domain.OTP;
import com.api.domain.repository.OTPRepository;
import com.api.infrastructure.entity.OTPEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JPAOTPRepository implements OTPRepository {

    @Autowired
    private com.api.infrastructure.repository.jpa.SpringJPAOTPRepository SpringJPAOTPRepository;

    @Override
    public Optional<OTP> findByEmailId(String emailId) {
        Optional<OTPEntity> optionalOTPEntity = SpringJPAOTPRepository.findTopByEmailIdOrderByIdDesc(emailId);
        if (optionalOTPEntity.isPresent()) {
            return Optional.of(new OTP(optionalOTPEntity.get().getId(),optionalOTPEntity.get().getEmailId(),optionalOTPEntity.get().getOtp()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void save(OTP otp) {
        SpringJPAOTPRepository.save(new OTPEntity(otp.getEmailId(), otp.getOtp()));
    }
}
