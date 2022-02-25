package com.mob.casestudy.digitalbanking.mapper;

import com.mob.casestudy.digitalbanking.entity.Customer;
import openapi.model.CreateCustomerRequestDto;
import openapi.model.CreateCustomerResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface CustomerMapper {

    Customer mapToEntity (CreateCustomerRequestDto createCustomerRequestDto);
    CreateCustomerResponseDto mapEntityToResponseDto(Customer savedCustomer);
}
