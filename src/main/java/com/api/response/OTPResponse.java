package com.api.response;

import lombok.Data;

@Data
public class OTPResponse {
    private String message;
    public OTPResponse(String message){
        this.message = message;
    }
}
