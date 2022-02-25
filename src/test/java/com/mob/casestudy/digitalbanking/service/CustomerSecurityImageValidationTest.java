package com.mob.casestudy.digitalbanking.service;

import com.mob.casestudy.digitalbanking.entity.Customer;
import com.mob.casestudy.digitalbanking.entity.CustomerSecurityImages;
import com.mob.casestudy.digitalbanking.entity.enumerator.Language;
import com.mob.casestudy.digitalbanking.entity.enumerator.UserStatus;
import com.mob.casestudy.digitalbanking.exception.CustomerSecurityImageNotFoundException;
import com.mob.casestudy.digitalbanking.exception.UserNotFoundException;
import com.mob.casestudy.digitalbanking.repository.CustomerRepository;
import com.mob.casestudy.digitalbanking.validation.CustomerSecurityImageValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CustomerSecurityImageValidationTest {

    @InjectMocks
    CustomerSecurityImageValidation customerSecurityImageValidation;

    @Mock
    CustomerRepository customerRepository;

    String userName = "Sg";
    Customer customer = Customer.builder().userName("Sg").
            firstName("Shreya").lastName("Gandhi").phoneNumber("1234567891").
            email("sgandhi@mail.com").status(UserStatus.ACTIVE).preferredLanguage(Language.EN).build();
    Optional<Customer> noCustomer;

    @Test
    void validateCustomer_withNo_UserNameFound() {
        Mockito.when(customerRepository.findByUserName(userName)).thenReturn(noCustomer);
        Assertions.assertThrows(UserNotFoundException.class, () -> customerSecurityImageValidation.validateCustomer(userName));
    }

    @Test
    void validateCustomer_withValid_UserNameFound() {
        Mockito.when(customerRepository.findByUserName(userName)).thenReturn(Optional.ofNullable(customer));
        customerSecurityImageValidation.validateCustomer(userName);
        Mockito.verify(customerRepository).findByUserName(userName);
    }

    @Test
    void validateImages() {
        CustomerSecurityImages customerSecurityImages = null;
        Assertions.assertThrows(CustomerSecurityImageNotFoundException.class, () -> customerSecurityImageValidation.validateCustomerSecurityImage(customerSecurityImages));
    }
}