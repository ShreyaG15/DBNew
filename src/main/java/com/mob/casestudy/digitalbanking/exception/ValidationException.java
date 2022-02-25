package com.mob.casestudy.digitalbanking.exception;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {

    private final String errorCode;
    private final String errorDescription;

    public ValidationException(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }
}
