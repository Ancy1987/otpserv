package com.api.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@ToString
public class OTP {
    private long id;
    private String emailId;
    private String otp;

    public OTP(String emailId, String otp) {
        this.emailId = emailId;
        this.otp = otp;
    }

    public OTP(long id, String emailId, String otp) {
        this.id = id;
        this.emailId = emailId;
        this.otp = otp;
    }
}
