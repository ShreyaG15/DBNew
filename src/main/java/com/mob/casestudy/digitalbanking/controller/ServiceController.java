package com.mob.casestudy.digitalbanking.controller;

import com.mob.casestudy.digitalbanking.entity.SecurityImages;
import com.mob.casestudy.digitalbanking.exception.ImageNotFoundException;
import com.mob.casestudy.digitalbanking.service.SecurityImageService;
import com.mob.casestudy.digitalbanking.validation.CustomerOtpValidationService;
import openapi.api.ServiceApiApi;
import openapi.model.GetSecurityImagesResponseDto;
import openapi.model.ValidateOtpRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer-service")
public class ServiceController implements ServiceApiApi {

    @Autowired
    private CustomerOtpValidationService customerOtpValidationService;

    @Autowired
    public SecurityImageService securityImageService;


    @Override
    public ResponseEntity<GetSecurityImagesResponseDto> getSecurityImages() {
        ResponseEntity<GetSecurityImagesResponseDto> allSecurityImages = securityImageService.getAllSecurityImages();
        return allSecurityImages;
    }

    @Override
    public ResponseEntity<Void> validateOtp(ValidateOtpRequestDto validateOtpRequestDto) {
        customerOtpValidationService.validateCustomerOtp(validateOtpRequestDto);
        return ResponseEntity.ok().build();
    }
}
