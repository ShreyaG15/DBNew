package com.mob.casestudy.digitalbanking.entity;

import com.mob.casestudy.digitalbanking.entity.embeddable.CustomerSecurityQuestionId;

import javax.persistence.*;

@Entity
public class CustomerSecurityQuestions {

    @EmbeddedId
    private CustomerSecurityQuestionId customerSecurityQuestionId;

    @Column(length = 50)
    private String securityQuestionAnswer;

    @Column(length = 50)
    private String createdOn;

    @ManyToOne
    @MapsId("customerId")
    private Customer customer;

    @OneToOne
    @MapsId("securityQuestionId")
    private SecurityQuestion securityQuestion;

    public CustomerSecurityQuestions() {
    }

    public CustomerSecurityQuestions(String securityQuestionAnswer, String createdOn) {
        this.securityQuestionAnswer = securityQuestionAnswer;
        this.createdOn = createdOn;
    }

    public CustomerSecurityQuestions(CustomerSecurityQuestionId customerSecurityQuestionId, String securityQuestionAnswer, String createdOn) {
        this.customerSecurityQuestionId = customerSecurityQuestionId;
        this.securityQuestionAnswer = securityQuestionAnswer;
        this.createdOn = createdOn;
    }

    public CustomerSecurityQuestionId getCustomerSecurityQuestionId() {
        return customerSecurityQuestionId;
    }

    public void setCustomerSecurityQuestionId(CustomerSecurityQuestionId customerSecurityQuestionId) {
        this.customerSecurityQuestionId = customerSecurityQuestionId;
    }

    public String getSecurityQuestionAnswer() {
        return securityQuestionAnswer;
    }

    public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
        this.securityQuestionAnswer = securityQuestionAnswer;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SecurityQuestion getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(SecurityQuestion securityQuestion) {
        this.securityQuestion = securityQuestion;
    }
}
