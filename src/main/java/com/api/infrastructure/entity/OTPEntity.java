package com.api.infrastructure.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "otp")
@Data
@NoArgsConstructor
@ToString
public class OTPEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "emailId")
    private String emailId;
    @Column(name = "otp")
    private String otp;

    public OTPEntity(String emailId, String otp) {
        this.emailId = emailId;
        this.otp = otp;
    }

}
