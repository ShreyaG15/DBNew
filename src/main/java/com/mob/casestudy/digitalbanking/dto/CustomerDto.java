package com.mob.casestudy.digitalbanking.dto;

import com.mob.casestudy.digitalbanking.entity.enumerator.Language;
import com.mob.casestudy.digitalbanking.entity.enumerator.UserStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomerDto {

    private String userName;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private UserStatus status;

    private Language preferredLanguage;

    public CustomerDto(String userName, String firstName, String lastName, String phoneNumber, String email, UserStatus status, Language preferredLanguage) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
        this.preferredLanguage = preferredLanguage;
    }
}
