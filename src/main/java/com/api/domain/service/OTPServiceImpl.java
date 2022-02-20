//package com.api.domain.service;
//
//import com.api.domain.Mail;
//import com.api.domain.repository.OTPRepository;
//import com.api.infrastructure.entity.OTPEntity;
//import com.api.request.SendOTPRequest;
//import com.api.request.VerifyOTPRequest;
//import com.api.response.OTPResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@Service
//@Transactional
//public class OTPServiceImpl implements OTPService{
//
//    @Autowired
//    private OTPRepository otpRepository;
//
//    @Autowired
//    private MailService mailService;
//
//    @Override
//    public OTPResponse createOTP(SendOTPRequest sendOTPRequest) {
//        java.util.Random r=new java.util.Random();
//        int otpNumber = r.nextInt(10000);
//        OTPEntity OTPEntity = new OTPEntity(sendOTPRequest.getEmailId(),String.valueOf(otpNumber));
//        OTPEntity OTPEntityNew =otpRepository.save(OTPEntity);
//        Mail mail = new Mail();
//        mail.setMailFrom("ancyr@monkeycap.com");
//        mail.setMailSubject("OTP");
//        mail.setMailTo(sendOTPRequest.getEmailId());
//        mail.setMailContent("OTP is "+ OTPEntityNew.getOtp());
//        mailService.sendEmail(mail);
//        OTPResponse send= new OTPResponse();
//        send.setMessage("Email send");
//   return send;
//    }
//
//    @Override
//    public OTPResponse verifyOTP(VerifyOTPRequest verifyOTPRequest) {
//        System.out.println("----------------------"+verifyOTPRequest.getEmailId());
//        OTPEntity OTPEntity = otpRepository.findTopByEmailIdOrderByIdDesc(verifyOTPRequest.getEmailId());
//        System.out.println("----------------------"+ OTPEntity);
//        OTPResponse otpResponse = new OTPResponse();
//        if(OTPEntity.getOtp().equalsIgnoreCase(verifyOTPRequest.getOtp())){
//            otpResponse.setMessage("Verified");
//        }else{
//            otpResponse.setMessage("Invalid");
//        }
//        return otpResponse;
//    }
//}
