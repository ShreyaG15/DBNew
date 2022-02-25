package com.mob.casestudy.digitalbanking.entity.embeddable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Embeddable
public class CustomerOtpId implements Serializable {

    private String customerId;

    private String otpId;

    public CustomerOtpId() {
        this.otpId = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOtpId that = (CustomerOtpId) o;
        return customerId.equals(that.customerId) && otpId.equals(that.otpId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, otpId);
    }
}
