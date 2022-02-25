package com.mob.casestudy.digitalbanking.entity;

import com.mob.casestudy.digitalbanking.entity.enumerator.Language;
import com.mob.casestudy.digitalbanking.entity.enumerator.UserStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, updatable = false, insertable = false,length = 36)
    private String id;

    @Column(length = 30)
    private String  userName;

    @Column(length = 50)
    private String  firstName;

    @Column(length = 50)
    private String  lastName;

    @Column(length = 10)
    private String phoneNumber;

    @Column(length = 50)
    private String email;

    @Column(length = 3)
    private Integer age;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(length = 2)
    @Enumerated(EnumType.STRING)
    private Language preferredLanguage;

    @Column(length = 50)
    private String externalId;

    @Column(length = 50)
    private String createdBy;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @Column(length = 50)
    private String updatedBy;

    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @OneToMany(mappedBy = "customer")
    private List<CustomerSecurityQuestions> customerSecurityQuestions = new ArrayList<>();

    @OneToOne(mappedBy = "customer")
    private CustomerSecurityImages customerSecurityImages;

    @OneToOne(mappedBy = "customer")
    private CustomerOtp customerOtp;

    public Customer(String userName, String firstName, String lastName, String phoneNumber, String email, UserStatus status, Language preferredLanguage) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
        this.preferredLanguage = preferredLanguage;
    }


    public void addCustomerSecurityQuestions(CustomerSecurityQuestions customerSecurityQuestions) {
        this.customerSecurityQuestions.add(customerSecurityQuestions);
    }

    public void removeCustomerSecurityQuestions(CustomerSecurityQuestions customerSecurityQuestions) {
        this.customerSecurityQuestions.remove(customerSecurityQuestions);
    }

    public CustomerSecurityImages getCustomerSecurityImages() {
        return customerSecurityImages;
    }

    public void setCustomerSecurityImages(CustomerSecurityImages customerSecurityImages) {
        this.customerSecurityImages=customerSecurityImages;
    }

    public CustomerOtp getCustomerOtp() {
        return customerOtp;
    }

    public void setCustomerOtp(CustomerOtp customerOtp) {
        this.customerOtp = customerOtp;
    }
}
