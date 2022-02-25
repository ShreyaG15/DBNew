package com.mob.casestudy.digitalbanking.constants;

public class ErrorCodes {

    private ErrorCodes() {
    }

    public static final String SECURITY_IMAGE_NOT_FOUND="SIM-GET-FIE-001";
    public static final String REQUESTED_USER_NOT_FOUND="CSI-GET-FIE-002";
    public static final String CUSTOMER_SECURITY_IMAGE_NOT_FOUND="CSI-GET-FIE-001";
    public static final String NULL_OR_EMPTY_OTP="OTP-VAL-FIE-002";
    public static final String OTP_EXPIRED="OTP-VAL-FIE-005";
    public static final String OTP_INVALID="OTP-VAL-FIE-003";
    public static final String OTP_ATTEMPTS_EXCEEDED="OTP-VAL-FIE-004";
    public static final String USERNAME_INVALID="Entered Username is not Valid";
    public static final String PHONE_NUMBER_INVALID="Entered Phone number is not Valid";
    public static final String EMAIL_INVALID="Entered Email is not Valid";
    public static final String LANGUAGE_INVALID="Entered Language is not Valid";
}
