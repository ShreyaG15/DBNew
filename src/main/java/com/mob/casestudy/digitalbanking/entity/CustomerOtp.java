package com.mob.casestudy.digitalbanking.entity;

import com.mob.casestudy.digitalbanking.entity.embeddable.CustomerOtpId;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOtp {

    @EmbeddedId
    private CustomerOtpId customerOtpId = new CustomerOtpId();

    @OneToOne
    @MapsId("customerId")
    private Customer customer;

    @Column(length = 160)
    private String otpMessage;

    @Column(length = 6)
    private String otp;

    @Column(scale = 1)
    private Integer optRetries;

    private LocalDateTime expiresOn;

    private LocalDateTime createdOn;

    public CustomerOtp(String otpMessage, String otp, Integer optRetries, LocalDateTime expiresOn, LocalDateTime createdOn) {
        this.otpMessage = otpMessage;
        this.otp = otp;
        this.optRetries = optRetries;
        this.expiresOn = expiresOn;
        this.createdOn = createdOn;
    }

    public CustomerOtp(CustomerOtpId customerOtpId, String otpMessage, String otp, Integer optRetries, LocalDateTime expiresOn, LocalDateTime createdOn) {
        this.customerOtpId = customerOtpId;
        this.otpMessage = otpMessage;
        this.otp = otp;
        this.optRetries = optRetries;
        this.expiresOn = expiresOn;
        this.createdOn = createdOn;
    }
}
