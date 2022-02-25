package com.mob.casestudy.digitalbanking;

import com.mob.casestudy.digitalbanking.entity.Customer;
import com.mob.casestudy.digitalbanking.service.CustomerOtpService;
import com.mob.casestudy.digitalbanking.service.CustomerSecurityImagesService;
import com.mob.casestudy.digitalbanking.service.CustomerService;
import com.mob.casestudy.digitalbanking.service.SecurityImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DigitalBankingNewApplication implements CommandLineRunner {

	@Autowired
	CustomerService customerService;
	@Autowired
	CustomerSecurityImagesService customerSecurityImagesService;
	@Autowired
	SecurityImageService securityImageService;
	@Autowired
	CustomerOtpService customerOtpService;

	public static void main(String[] args) {
		SpringApplication.run(DigitalBankingNewApplication.class, args);
	}

	@Bean
	RestTemplate getObject(){
		return new RestTemplate();
	}

	@Override
	public void run(String... args) {
		Customer customer = customerService.addCustomer();
		securityImageService.addSecurityImages();
		customerSecurityImagesService.addImage();
		customerOtpService.addOtpDetails(customer);
	}
}
