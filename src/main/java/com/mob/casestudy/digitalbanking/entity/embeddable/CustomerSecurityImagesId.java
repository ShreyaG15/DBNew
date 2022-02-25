package com.mob.casestudy.digitalbanking.entity.embeddable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class CustomerSecurityImagesId implements Serializable {

    private String customerId;

    private String securityImageId;

    public CustomerSecurityImagesId() {
    }

    public CustomerSecurityImagesId(String customerId, String securityImageId) {
        this.customerId = customerId;
        this.securityImageId = securityImageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerSecurityImagesId that = (CustomerSecurityImagesId) o;
        return customerId.equals(that.customerId) && securityImageId.equals(that.securityImageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, securityImageId);
    }
}
