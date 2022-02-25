package com.mob.casestudy.digitalbanking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SecurityQuestion {

    @Id
    @Column(length =36)
    private String id;

    @Column(length = 50)
    private String securityQuestionText;

    @OneToOne(mappedBy = "securityQuestion")
    private CustomerSecurityQuestions customerSecurityQuestions;

    public SecurityQuestion() {
    }

    public SecurityQuestion(String securityQuestionText) {
        this.securityQuestionText = securityQuestionText;
    }

    public SecurityQuestion(String id, String securityQuestionText) {
        this.id = id;
        this.securityQuestionText = securityQuestionText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecurityQuestionText() {
        return securityQuestionText;
    }

    public void setSecurityQuestionText(String securityQuestionText) {
        this.securityQuestionText = securityQuestionText;
    }

    public CustomerSecurityQuestions getCustomerSecurityQuestions() {
        return customerSecurityQuestions;
    }

    public void setCustomerSecurityQuestions(CustomerSecurityQuestions customerSecurityQuestions) {
        this.customerSecurityQuestions = customerSecurityQuestions;
    }
}
