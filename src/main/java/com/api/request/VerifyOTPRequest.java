package com.api.request;

import lombok.Data;

@Data
public class VerifyOTPRequest {
    private String emailId;
    private String otp;
}
