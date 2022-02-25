package com.mob.casestudy.digitalbanking.repository;

import com.mob.casestudy.digitalbanking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByUserName(String userName);
    boolean existsByUserName(String userName);
}
