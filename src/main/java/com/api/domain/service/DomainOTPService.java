package com.api.domain.service;

import com.api.domain.Mail;
import com.api.domain.OTP;
import com.api.domain.repository.OTPRepository;
import com.api.request.VerifyOTPRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DomainOTPService implements OTPService{

    @Autowired
    private  OTPRepository otpRepository;

    @Autowired
    private MailService mailService;

//    public DomainOTPService(final OTPRepository otpRepository) {
//        this.otpRepository = otpRepository;
//    }

    @Override
    public long createOTP(String emailId) {
        java.util.Random r=new java.util.Random();
        int otpNumber = r.nextInt(10000);
        OTP otp = new OTP(emailId,String.valueOf(otpNumber));
        otpRepository.save(otp);
        Mail mail = new Mail();
        mail.setMailFrom("ancyr@monkeycap.com");
        mail.setMailSubject("OTP");
        mail.setMailTo(emailId);
        mail.setMailContent("OTP is "+ otp.getOtp());
        mailService.sendEmail(mail);
        return 0;
    }

    @Override
    public long verifyOTP(VerifyOTPRequest verifyOTPRequest) {
        long response = -1;
       Optional<OTP> otpOptional =  otpRepository.findByEmailId(verifyOTPRequest.getEmailId());
       if(otpOptional.isPresent()){
           OTP otp = otpOptional.get();
           if(otp.getOtp().equalsIgnoreCase(verifyOTPRequest.getOtp())){
               response =0;
           }
       }
        return response;
    }
}
