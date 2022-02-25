package com.mob.casestudy.digitalbanking.validation;

import com.mob.casestudy.digitalbanking.entity.Customer;
import com.mob.casestudy.digitalbanking.entity.CustomerOtp;
import com.mob.casestudy.digitalbanking.exception.*;
import com.mob.casestudy.digitalbanking.repository.CustomerOtpRepository;
import com.mob.casestudy.digitalbanking.repository.CustomerRepository;
import openapi.model.ValidateOtpRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Component
public class CustomerOtpValidationService {
    private final CustomerRepository customerRepository;
    private final CustomerOtpRepository customerOtpRepository;

    @Autowired
    public CustomerOtpValidationService(CustomerRepository customerRepository, CustomerOtpRepository customerOtpRepository) {
        this.customerRepository = customerRepository;
        this.customerOtpRepository = customerOtpRepository;
    }

    public void validateCustomerOtp(ValidateOtpRequestDto validateOtpRequestDto) {
        String userName = validateOtpRequestDto.getUserName();
        String customerProvidedOtp = validateOtpRequestDto.getOtp();
        Optional<Customer> customer = customerRepository.findByUserName(userName);
        if (Objects.isNull(customer)||userName.isEmpty()) {
            throw new UserNotFoundException("The requested user is not found");
        }
        validateNullOrEmptyOtp(customerProvidedOtp);
        validateExpiredOtp(customer);
        validateInvalidOtpAndOtpAttempts(customer, customerProvidedOtp);
    }

    public void validateNullOrEmptyOtp(String customerProvidedOtp) {
        if (Objects.isNull(customerProvidedOtp) || customerProvidedOtp.isEmpty()) {
            throw new OtpEmptyOrNullException("Null or Empty OTP not acceptable");
        }
    }

    public void validateExpiredOtp(Optional<Customer> customer) {
        CustomerOtp customerOtp = customer.get().getCustomerOtp();
        LocalDateTime expiryOn = customerOtp.getExpiresOn();
        LocalDateTime requestedTime = LocalDateTime.now();
        if (requestedTime.isAfter(expiryOn)) {
            throw new OtpInitiatedExpiredException();
        }
    }

    public void validateInvalidOtpAndOtpAttempts(Optional<Customer> customer, String customerProvidedOtp){
        CustomerOtp customerOtp = customer.get().getCustomerOtp();
        Integer otpRetries = customerOtp.getOptRetries();
        String existOtp = customerOtp.getOtp();
        if (otpRetries <= 2){
            if (!customerProvidedOtp.equals(existOtp)){
                customerOtp.setOptRetries(++otpRetries);
                customerOtpRepository.saveAndFlush(customerOtp);
                throw new OtpInvalidException();
            }
        } else {
            throw new OtpFailedAttemptException();
        }
    }
}
