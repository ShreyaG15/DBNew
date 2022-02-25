package com.mob.casestudy.digitalbanking.service;

import com.mob.casestudy.digitalbanking.controller.ExternalController;
import com.mob.casestudy.digitalbanking.entity.Customer;
import com.mob.casestudy.digitalbanking.entity.enumerator.Language;
import com.mob.casestudy.digitalbanking.entity.enumerator.UserStatus;
import com.mob.casestudy.digitalbanking.exception.UserNotFoundException;
import com.mob.casestudy.digitalbanking.mapper.CustomerMapperImpl;
import com.mob.casestudy.digitalbanking.repository.CustomerRepository;
import com.mob.casestudy.digitalbanking.validation.CustomerValidation;
import openapi.model.CreateCustomerRequestDto;
import openapi.model.CreateCustomerResponseDto;
import openapi.model.PatchCustomerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Transactional
@Component
public class CustomerService {

    CustomerRepository customerRepository;
    CustomerMapperImpl customerMapperImpl;
    CustomerValidation customerValidation;
    private final ExternalController externalController;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapperImpl customerMapperImpl, ExternalController externalController, CustomerValidation customerValidation) {
        this.customerRepository = customerRepository;
        this.customerMapperImpl = customerMapperImpl;
        this.externalController = externalController;
        this.customerValidation = customerValidation;

    }

    public Customer addCustomer() {
        Customer customerBuilder = Customer.builder().userName("Sg").
                firstName("Shreya").lastName("Gandhi").phoneNumber("1234567891").
                email("sgandhi@gmail.com").status(UserStatus.ACTIVE).
                preferredLanguage(Language.EN).build();
        return customerRepository.save(customerBuilder);
    }

    public ResponseEntity<CreateCustomerResponseDto> postCustomers(CreateCustomerRequestDto createCustomerRequestDto) {

        customerValidation.validationForCreateCustomer(createCustomerRequestDto);

        Customer customer = getCustomer(createCustomerRequestDto);

        Customer savedCustomer = customerRepository.save(customer);

        CreateCustomerResponseDto createCustomerResponseDto = customerMapperImpl.mapEntityToResponseDto(savedCustomer);

        return new ResponseEntity<>(createCustomerResponseDto, HttpStatus.CREATED);
    }

    private Customer getCustomer(CreateCustomerRequestDto createCustomerRequestDto) {
        Customer customer = customerMapperImpl.mapToEntity(createCustomerRequestDto);
        int age = externalController.getAgeByExternalApi(createCustomerRequestDto.getUserName());
        customer.setStatus(UserStatus.ACTIVE);
        customer.setPreferredLanguage(Language.EN);
        customer.setCreatedBy("System");
        customer.setUpdatedBy("System");
        customer.setAge(age);
        customer.setExternalId(customer.getUserName().concat("_ext"));
        return customer;
    }


    public ResponseEntity<Void> patchCustomerByUserName(String username, PatchCustomerRequestDto patchCustomerRequestDto) {
        Optional<Customer> optionalCustomer = customerRepository.findByUserName(username);
        if (optionalCustomer.isEmpty()) {
            throw new UserNotFoundException("The requested user is not found");
        }

        Customer customer = optionalCustomer.get();
        customerValidation.validationForPatchCustomer(patchCustomerRequestDto);

        if (!Objects.isNull(patchCustomerRequestDto.getFirstName()) && !patchCustomerRequestDto.getFirstName().isEmpty()) {
            customer.setFirstName(patchCustomerRequestDto.getFirstName());
        }
        if (!Objects.isNull(patchCustomerRequestDto.getLastName())) {
            customer.setLastName(patchCustomerRequestDto.getLastName());
        }
        if (!Objects.isNull(patchCustomerRequestDto.getPhoneNumber())) {
            customer.setPhoneNumber(patchCustomerRequestDto.getPhoneNumber());
        }
        if (!Objects.isNull(patchCustomerRequestDto.getEmail())) {
            customer.setEmail(patchCustomerRequestDto.getEmail());
        }
        if (!Objects.isNull(patchCustomerRequestDto.getPreferredLanguage())) {
            customer.setPreferredLanguage(Language.valueOf(patchCustomerRequestDto.getPreferredLanguage().getValue()));
        }
        customerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

