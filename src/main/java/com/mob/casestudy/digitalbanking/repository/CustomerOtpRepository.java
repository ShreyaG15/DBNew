package com.mob.casestudy.digitalbanking.repository;

import com.mob.casestudy.digitalbanking.entity.CustomerOtp;
import com.mob.casestudy.digitalbanking.entity.embeddable.CustomerOtpId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOtpRepository extends JpaRepository<CustomerOtp, CustomerOtpId> {
}
