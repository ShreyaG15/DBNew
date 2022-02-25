package com.mob.casestudy.digitalbanking.service;

import com.mob.casestudy.digitalbanking.entity.SecurityImages;
import com.mob.casestudy.digitalbanking.exception.ImageNotFoundException;
import com.mob.casestudy.digitalbanking.repository.SecurityImageRepository;
import openapi.model.GetSecurityImagesResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityImageService {

    @Autowired
    private SecurityImageRepository securityImageRepository;

    public List<SecurityImages> findAll() {
        return securityImageRepository.findAll();
    }

    public void addSecurityImages() {
        SecurityImages securityImagesBuilder = SecurityImages.builder().
                securityImageName("Sunflower").
                securityImageUrl("https://images.unsplash.com/photo-1548291616-bfccc8db731d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=927&q=80").build();
        securityImageRepository.save(securityImagesBuilder);
    }

    public ResponseEntity<GetSecurityImagesResponseDto> getAllSecurityImages() {
        List<SecurityImages> list = securityImageRepository.findAll();
        GetSecurityImagesResponseDto securityImages = new GetSecurityImagesResponseDto();
        if (list.isEmpty()) {
            throw new ImageNotFoundException();
        }
        for (SecurityImages securityImages1 : list) {
            securityImages.addSecurityImagesItem(securityImages1.toDto());
        }
        return ResponseEntity.ok().body(securityImages);
    }
}





