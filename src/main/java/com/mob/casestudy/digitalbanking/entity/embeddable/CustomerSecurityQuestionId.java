package com.mob.casestudy.digitalbanking.entity.embeddable;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CustomerSecurityQuestionId implements Serializable {

    private String customerId;

    private String securityQuestionId;

    public CustomerSecurityQuestionId() {
    }

    public CustomerSecurityQuestionId(String customerId, String securityQuestionId) {
        this.customerId = customerId;
        this.securityQuestionId = securityQuestionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getSecurityQuestionId() {
        return securityQuestionId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setSecurityQuestionId(String securityQuestionId) {
        this.securityQuestionId = securityQuestionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerSecurityQuestionId that = (CustomerSecurityQuestionId) o;
        return customerId.equals(that.customerId) && securityQuestionId.equals(that.securityQuestionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, securityQuestionId);
    }
}
