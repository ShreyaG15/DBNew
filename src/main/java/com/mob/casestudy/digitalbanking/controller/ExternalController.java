package com.mob.casestudy.digitalbanking.controller;

import com.mob.casestudy.digitalbanking.dto.AgeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Component
public class ExternalController {

    @Autowired
    RestTemplate restTemplate;

    public int getAgeByExternalApi(String name){
        return restTemplate.exchange("https://api.agify.io/?name="+name+"", HttpMethod.GET, null, AgeDto.class).getBody().getAge();
    }
}
