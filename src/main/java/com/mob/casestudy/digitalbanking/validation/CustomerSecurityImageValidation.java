package com.mob.casestudy.digitalbanking.validation;

import com.mob.casestudy.digitalbanking.entity.Customer;
import com.mob.casestudy.digitalbanking.entity.CustomerSecurityImages;
import com.mob.casestudy.digitalbanking.exception.CustomerSecurityImageNotFoundException;
import com.mob.casestudy.digitalbanking.exception.UserNotFoundException;
import com.mob.casestudy.digitalbanking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerSecurityImageValidation {

    private final CustomerRepository customerRepository;
@Autowired
    public CustomerSecurityImageValidation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> validateCustomer(String userName) {
        Optional<Customer> customer = customerRepository.findByUserName(userName);
        if (Objects.isNull(customer)) {
            throw new UserNotFoundException("The requested user is not found");
        }
        return customer;
    }

    public void validateCustomerSecurityImage(CustomerSecurityImages customerSecurityImages) {
        if (Objects.isNull(customerSecurityImages)) {
            throw new CustomerSecurityImageNotFoundException();
        }
    }
}
