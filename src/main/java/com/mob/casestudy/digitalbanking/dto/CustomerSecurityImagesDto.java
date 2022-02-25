package com.mob.casestudy.digitalbanking.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@NoArgsConstructor
@ToString
public class CustomerSecurityImagesDto {
    private String securityImageId;
    private String securityImageName;
    private String securityImageCaption;
    private String securityImageUrl;

    public CustomerSecurityImagesDto(String securityImageId, String securityImageName, String securityImageCaption, String getSecurityImageUrl) {
        this.securityImageId = securityImageId;
        this.securityImageName = securityImageName;
        this.securityImageCaption = securityImageCaption;
        this.securityImageUrl = getSecurityImageUrl;
    }
}
