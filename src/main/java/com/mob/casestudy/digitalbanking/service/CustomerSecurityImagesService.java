package com.mob.casestudy.digitalbanking.service;

import com.mob.casestudy.digitalbanking.entity.Customer;
import com.mob.casestudy.digitalbanking.entity.CustomerSecurityImages;
import com.mob.casestudy.digitalbanking.repository.CustomerRepository;
import com.mob.casestudy.digitalbanking.repository.CustomerSecurityImagesRepo;
import com.mob.casestudy.digitalbanking.repository.SecurityImageRepository;
import com.mob.casestudy.digitalbanking.validation.CustomerSecurityImageValidation;
import openapi.model.GetCustomerSecurityImageResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class CustomerSecurityImagesService {

    CustomerSecurityImagesRepo customerSecurityImagesRepo;
    CustomerRepository customerRepository;
    SecurityImageRepository securityImageRepository;
    CustomerSecurityImageValidation customerSecurityImageValidation;

    @Autowired
    public CustomerSecurityImagesService(CustomerSecurityImagesRepo customerSecurityImagesRepo, CustomerRepository customerRepository, SecurityImageRepository securityImageRepository, CustomerSecurityImageValidation customerSecurityImageValidation) {
        this.customerSecurityImagesRepo = customerSecurityImagesRepo;
        this.customerRepository = customerRepository;
        this.securityImageRepository = securityImageRepository;
        this.customerSecurityImageValidation = customerSecurityImageValidation;
    }

    public void addImage() {
        CustomerSecurityImages customer1 = new CustomerSecurityImages();
        Optional<Customer> customer = customerRepository.findByUserName("Sg");
        customer1.setCustomer(customer.get());
        customer1.setSecurityImages(securityImageRepository.findBySecurityImageName("Sunflower"));
        customer1.setSecurityImageCaption("Flower");
        customer1.setCreatedOn(LocalDateTime.now().toString());
        customerSecurityImagesRepo.save(customer1);
    }

    public ResponseEntity<GetCustomerSecurityImageResponseDto> retrieveCustomerSecurityImage(String username) {
        Optional<Customer> customer = customerSecurityImageValidation.validateCustomer(username);
        CustomerSecurityImages customerSecurityImages = customer.get().getCustomerSecurityImages();
        customerSecurityImageValidation.validateCustomerSecurityImage(customerSecurityImages);
        customerSecurityImages.toDto();
        return ResponseEntity.ok().body(customerSecurityImages.toDto());
    }
}
