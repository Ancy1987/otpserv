package com.api.domain.service;

import com.api.domain.Mail;
import org.springframework.stereotype.Service;

@Service
public interface MailService {
    public void sendEmail(Mail mail);
}
