package com.mob.casestudy.digitalbanking.entity;


import com.mob.casestudy.digitalbanking.entity.embeddable.CustomerSecurityImagesId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import openapi.model.GetCustomerSecurityImageResponseDto;
import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class CustomerSecurityImages {

    @EmbeddedId
    private CustomerSecurityImagesId customerSecurityImagesId = new CustomerSecurityImagesId();

    @Column(length = 50)
    private String securityImageCaption;

    @Column(length = 50)
    private String createdOn;

    @OneToOne
    @MapsId("customerId")
    private Customer customer;

    @OneToOne
    @MapsId("securityImageId")
    private SecurityImages securityImages;

    public GetCustomerSecurityImageResponseDto toDto(){
        GetCustomerSecurityImageResponseDto getCustomerSecurityImageResponseDto = new GetCustomerSecurityImageResponseDto();
        getCustomerSecurityImageResponseDto.setSecurityImageId(customerSecurityImagesId.getSecurityImageId());
        getCustomerSecurityImageResponseDto.setSecurityImageName(securityImages.getSecurityImageName());
        getCustomerSecurityImageResponseDto.setSecurityImageCaption(securityImageCaption);
        getCustomerSecurityImageResponseDto.setSecurityImageUrl(securityImages.getSecurityImageUrl());

        return getCustomerSecurityImageResponseDto;
    }
}