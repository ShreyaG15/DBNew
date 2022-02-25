package com.mob.casestudy.digitalbanking.exceptionhandler;

import com.mob.casestudy.digitalbanking.exception.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import static com.mob.casestudy.digitalbanking.constants.ErrorCodes.*;

@ControllerAdvice
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ImageNotFoundException.class)
    public final ResponseEntity<Object> securityImageNotFoundException() {
        ExceptionResponse exceptionResponse = new ExceptionResponse(SECURITY_IMAGE_NOT_FOUND, "Security Image not found");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> userNotFoundException() {
        ExceptionResponse exceptionResponse = new ExceptionResponse(REQUESTED_USER_NOT_FOUND, "The requested user is not found");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerSecurityImageNotFoundException.class)
    public final ResponseEntity<Object> customerSecurityImageNotFoundException() {
        ExceptionResponse exceptionResponse = new ExceptionResponse(CUSTOMER_SECURITY_IMAGE_NOT_FOUND, "Customer Security Image not found");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OtpEmptyOrNullException.class)
    public final ResponseEntity<Object> otpEmptyOrNullException() {
        ExceptionResponse exceptionResponse = new ExceptionResponse(NULL_OR_EMPTY_OTP, "Null or Empty OTP not acceptable");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OtpInitiatedExpiredException.class)
    public final ResponseEntity<Object> otpInitiatedExpiredException() {
        ExceptionResponse exceptionResponse = new ExceptionResponse(OTP_EXPIRED, "The entered OTP is expired");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OtpInvalidException.class)
    public final ResponseEntity<Object> otpInvalidException() {
        ExceptionResponse exceptionResponse = new ExceptionResponse(OTP_INVALID, "The entered OTP is Invalid");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OtpFailedAttemptException.class)
    public final ResponseEntity<Object> otpFailedAttemptException() {
        ExceptionResponse exceptionResponse = new ExceptionResponse(OTP_ATTEMPTS_EXCEEDED, "You have exceeded OTP attempts of Max 3 times");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EnteredDataNotValid.class)
    public final ResponseEntity<Object> enteredDataNotValid() {
        ExceptionResponse exceptionResponse = new ExceptionResponse("400", "Entered data is not valid");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    public final ResponseEntity<Object> validationException(ValidationException validationException) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(validationException.getErrorCode(), validationException.getErrorDescription());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ex.getMessage();
        ExceptionResponse exceptionResponse=null;
        if(ex.getMessage().contains("PreferredLanguage")){
            exceptionResponse = new ExceptionResponse("400", "Invalid Preferred Language");
        }
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
