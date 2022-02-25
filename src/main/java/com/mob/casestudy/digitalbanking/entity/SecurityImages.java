package com.mob.casestudy.digitalbanking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mob.casestudy.digitalbanking.dto.SecurityImagesDto;
import lombok.*;
import openapi.model.SecurityImageDto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecurityImages {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, updatable = false, insertable = false,length = 36)
    private String id;

    @Column(length = 50)
    private String securityImageName;

    @Column(length = 255)
    private String securityImageUrl;

    @OneToMany(mappedBy = "securityImages")
    @JsonIgnore
    private List<CustomerSecurityImages> customerSecurityImages = new ArrayList<>();

    public SecurityImages(String id, String securityImageName, String securityImageURL) {
        this.id=id;
        this.securityImageName=securityImageName;
        this.securityImageUrl=securityImageURL;
    }

    public SecurityImageDto toDto(){
        SecurityImageDto securityImageDto = new SecurityImageDto();
        securityImageDto.setSecurityImageId(id);
        securityImageDto.setSecurityImageName(securityImageName);
        securityImageDto.setSecurityImageUrl(securityImageUrl);
        return securityImageDto;
    }
}


