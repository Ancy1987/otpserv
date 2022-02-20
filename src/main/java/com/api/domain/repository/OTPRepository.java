package com.api.domain.repository;

import com.api.domain.OTP;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface OTPRepository {
    Optional<OTP> findByEmailId(String emailId);

    void save(OTP otp);
}
