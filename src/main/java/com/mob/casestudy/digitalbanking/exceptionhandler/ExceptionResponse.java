package com.mob.casestudy.digitalbanking.exceptionhandler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {
    private String errorCode;
    private String errorDescription;

    public ExceptionResponse(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }
}

