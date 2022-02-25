package com.mob.casestudy.digitalbanking.validation;

import com.mob.casestudy.digitalbanking.exception.ValidationException;
import com.mob.casestudy.digitalbanking.repository.CustomerRepository;
import openapi.model.CreateCustomerRequestDto;
import openapi.model.PatchCustomerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

import static com.mob.casestudy.digitalbanking.constants.ErrorCodes.*;
import static com.mob.casestudy.digitalbanking.constants.RegexPatterns.*;

@Service
public class CustomerValidation {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerValidation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public boolean doesMatches(String value, String pattern) {
        return Pattern.compile(pattern)
                .matcher(value)
                .matches();
    }

    public void validationForCreateCustomer(CreateCustomerRequestDto createCustomerRequestDto) {

        if (!doesMatches(createCustomerRequestDto.getUserName(), USER_NAME_REGEX)) {
            throw new ValidationException(HttpStatus.BAD_REQUEST.toString(), USERNAME_INVALID);
        }
        if (!doesMatches(createCustomerRequestDto.getPhoneNumber(), PHONE_NUMBER_REGEX)) {
            throw new ValidationException(HttpStatus.BAD_REQUEST.toString(), PHONE_NUMBER_INVALID);
        }
        if (!doesMatches(createCustomerRequestDto.getEmail(), EMAIL_REGEX)) {
            throw new ValidationException(HttpStatus.BAD_REQUEST.toString(), EMAIL_INVALID);
        }
        if (customerRepository.existsByUserName(createCustomerRequestDto.getUserName())) {
            throw new ValidationException(HttpStatus.BAD_REQUEST.toString(), "User Already exist with same name.");
        }
    }

    public void validationForPatchCustomer(PatchCustomerRequestDto patchCustomerRequestDto) {
        if (!doesMatches(patchCustomerRequestDto.getPhoneNumber(), PHONE_NUMBER_REGEX)) {
            throw new ValidationException(HttpStatus.BAD_REQUEST.toString(), PHONE_NUMBER_INVALID);
        }
        if (!doesMatches(patchCustomerRequestDto.getEmail(), EMAIL_REGEX)) {
            throw new ValidationException(HttpStatus.BAD_REQUEST.toString(), EMAIL_INVALID);
        }
        if (!doesMatches(patchCustomerRequestDto.getPreferredLanguage().toString(), LANGUAGE_REGEX)) {
            throw new ValidationException(HttpStatus.BAD_REQUEST.toString(), LANGUAGE_INVALID);
        }
    }
}