package com.mob.casestudy.digitalbanking.controller;

import com.mob.casestudy.digitalbanking.service.CustomerSecurityImagesService;
import com.mob.casestudy.digitalbanking.service.CustomerService;
import openapi.api.ClientApiApi;
import openapi.model.CreateCustomerRequestDto;
import openapi.model.CreateCustomerResponseDto;
import openapi.model.GetCustomerSecurityImageResponseDto;
import openapi.model.PatchCustomerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-service")
public class ClientController implements ClientApiApi {


    private CustomerSecurityImagesService customerSecurityImagesService;
    private CustomerService customerService;

    @Autowired
    public ClientController(CustomerSecurityImagesService customerSecurityImagesService, CustomerService customerService) {
        this.customerSecurityImagesService = customerSecurityImagesService;
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<GetCustomerSecurityImageResponseDto> getSecurityImageByUserName(String username) {
        return customerSecurityImagesService.retrieveCustomerSecurityImage(username);
    }

    @Override
    public ResponseEntity<CreateCustomerResponseDto> postCustomers(CreateCustomerRequestDto createCustomerRequestDto) {
        return customerService.postCustomers(createCustomerRequestDto);
    }

    @Override
    public ResponseEntity<Void> patchCustomerByUserName(String username, PatchCustomerRequestDto patchCustomerRequestDto) {
        return customerService.patchCustomerByUserName(username, patchCustomerRequestDto);
    }
}
