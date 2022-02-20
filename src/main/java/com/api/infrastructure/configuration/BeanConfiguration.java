//package com.api.infrastructure.configuration;
//
//import com.api.OtpApplication;
//import com.api.domain.repository.OTPRepository;
//import com.api.domain.service.DomainOTPService;
//import com.api.domain.service.OTPService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@ComponentScan(basePackageClasses = OtpApplication.class)
//public class BeanConfiguration {
//
//    @Bean
//    OTPService otpService(final OTPRepository otpRepository) {
//        return new DomainOTPService(otpRepository);
//    }
//}
