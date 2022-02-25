package com.mob.casestudy.digitalbanking.service;

import com.mob.casestudy.digitalbanking.entity.Customer;
import com.mob.casestudy.digitalbanking.entity.CustomerOtp;
import com.mob.casestudy.digitalbanking.entity.embeddable.CustomerOtpId;
import com.mob.casestudy.digitalbanking.repository.CustomerOtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomerOtpService {

    @Autowired
    CustomerOtpRepository customerOtpRepository;

    public void addOtpDetails(Customer customer) {
        CustomerOtp customerBuilder = CustomerOtp.builder().customerOtpId(new CustomerOtpId())
                .otp("150698")
                .otpMessage("This is the respective One-time-password")
                .createdOn(LocalDateTime.now())
                .expiresOn(LocalDateTime.now().plusMinutes(5))
                .optRetries(0)
                .build();
        customerBuilder.setCustomer(customer);
        customerOtpRepository.save(customerBuilder);
    }
}
