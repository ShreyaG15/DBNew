package com.mob.casestudy.digitalbanking.repository;

import com.mob.casestudy.digitalbanking.entity.SecurityImages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityImageRepository extends JpaRepository<SecurityImages, String> {
    SecurityImages findBySecurityImageName(String name);
}
