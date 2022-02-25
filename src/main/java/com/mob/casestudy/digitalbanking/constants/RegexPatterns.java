package com.mob.casestudy.digitalbanking.constants;

public class RegexPatterns {

    public static final String PHONE_NUMBER_REGEX = "[\\d]{10}";
    public static final String USER_NAME_REGEX = "^[A-Za-z][A-Za-z0-9_]{7,29}$";
    public static final String EMAIL_REGEX = "[\\w+.]*@\\w+\\.([com]{3}|[in]{2})";
    public static final String LANGUAGE_REGEX = "EN|DE|FR";
}
