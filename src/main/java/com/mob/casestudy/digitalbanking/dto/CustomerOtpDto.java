package com.mob.casestudy.digitalbanking.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class CustomerOtpDto {
    private String userName;
    private String otp;
}
