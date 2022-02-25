package com.mob.casestudy.digitalbanking.dto;

import openapi.model.SecurityImageDto;

import java.util.ArrayList;
import java.util.List;

public class SecurityImagesList {


    private List<SecurityImageDto> securityImages = new ArrayList<>();

    public List<SecurityImageDto> getSecurityImages() {
        return securityImages;
    }

    public void addSecurityImages(SecurityImageDto securityImages) {
        this.securityImages.add(securityImages);
    }

}
