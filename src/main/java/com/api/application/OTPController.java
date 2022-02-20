package com.api.application;

import com.api.domain.service.OTPService;
import com.api.request.SendOTPRequest;
import com.api.request.VerifyOTPRequest;
import com.api.response.OTPResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class OTPController {

    @Autowired
    private OTPService otpService;

    @PostMapping(value = "/send-otp",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OTPResponse sendOTP(@RequestBody final SendOTPRequest sendOTPRequest) {
        long id = otpService.createOTP(sendOTPRequest.getEmailId());
        String msg = "Successfully send OTP";
        if(id == -1){
            msg ="Unable to send";
        }
        return new OTPResponse(msg);
    }

    @PostMapping(value = "/verify-otp",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OTPResponse verifyOTP(@RequestBody final VerifyOTPRequest verifyOTPRequest) {
        long id =  otpService.verifyOTP(verifyOTPRequest);
        String msg = "Valid OTP";
        if(id == -1){
            msg ="Invalid OTP";
        }
        return new OTPResponse(msg);
    }


}
