package com.mob.casestudy.digitalbanking.validation;

import com.mob.casestudy.digitalbanking.entity.Customer;
import com.mob.casestudy.digitalbanking.entity.CustomerOtp;
import com.mob.casestudy.digitalbanking.exception.OtpEmptyOrNullException;
import com.mob.casestudy.digitalbanking.exception.OtpInitiatedExpiredException;
import com.mob.casestudy.digitalbanking.exception.UserNotFoundException;
import com.mob.casestudy.digitalbanking.repository.CustomerOtpRepository;
import com.mob.casestudy.digitalbanking.repository.CustomerRepository;
import openapi.model.ValidateOtpRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CustomerOtpValidationServiceTest {

    @InjectMocks
    CustomerOtpValidationService customerOtpValidationService;
    @Mock
    CustomerRepository customerRepository;
    @Mock
    CustomerOtpRepository customerOtpRepository;

    CustomerOtpValidationServiceTest() {
    }

    @Test
    void validateCustomerOtp_validation_throwsException() {
        ValidateOtpRequestDto validateOtpRequestDto = new ValidateOtpRequestDto();
        validateOtpRequestDto.setOtp("150698");
        validateOtpRequestDto.setUserName("Sg");
        Mockito.when(customerRepository.findByUserName("Sg")).thenReturn(null);
        Assertions.assertThrows(UserNotFoundException.class, () -> customerOtpValidationService.validateCustomerOtp(validateOtpRequestDto));
    }

    @Test
    void validateCustomerOtp_validation_throwsOtpNullException() {
        Customer customer = new Customer();
        ValidateOtpRequestDto validateOtpRequestDto = new ValidateOtpRequestDto();
        validateOtpRequestDto.setOtp(null);
        validateOtpRequestDto.setUserName("Sg");
        Mockito.when(customerRepository.findByUserName("Sg")).thenReturn(Optional.of(customer));
        Assertions.assertThrows(OtpEmptyOrNullException.class, () -> customerOtpValidationService.validateCustomerOtp(validateOtpRequestDto));
    }

    @Test
    void validateCustomerOtp_validation_throwsExpiredException() {
        CustomerOtp customerOtp = new CustomerOtp();
        customerOtp.setExpiresOn(LocalDateTime.now().minusMinutes(5));
        Customer customer = new Customer();
        customer.setCustomerOtp(customerOtp);
        ValidateOtpRequestDto validateOtpRequestDto = new ValidateOtpRequestDto();
        validateOtpRequestDto.setOtp("150698");
        validateOtpRequestDto.setUserName("Sg");
        Mockito.when(customerRepository.findByUserName("Sg")).thenReturn(Optional.of(customer));
        Assertions.assertThrows(OtpInitiatedExpiredException.class, () -> customerOtpValidationService.validateCustomerOtp(validateOtpRequestDto));
    }
}