package com.api.domain.service;

import com.api.request.SendOTPRequest;
import com.api.request.VerifyOTPRequest;
import com.api.response.OTPResponse;
import org.springframework.stereotype.Service;

@Service
public interface OTPService {

    long createOTP(String emailId);
    long verifyOTP(VerifyOTPRequest verifyOTPRequest);
}
