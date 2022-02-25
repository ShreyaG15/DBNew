package com.mob.casestudy.digitalbanking.repository;

import com.mob.casestudy.digitalbanking.entity.CustomerSecurityImages;
import com.mob.casestudy.digitalbanking.entity.embeddable.CustomerSecurityImagesId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerSecurityImagesRepo extends JpaRepository<CustomerSecurityImages, CustomerSecurityImagesId> {
}
