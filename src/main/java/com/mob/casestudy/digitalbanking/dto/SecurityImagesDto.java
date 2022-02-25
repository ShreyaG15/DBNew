package com.mob.casestudy.digitalbanking.dto;

import com.mob.casestudy.digitalbanking.entity.SecurityImages;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SecurityImagesDto {

    private String id;

    private String securityImageName;

    private String securityImageURL;

    public SecurityImagesDto(String id, String securityImageName, String securityImageURL) {
        this.id = id;
        this.securityImageName = securityImageName;
        this.securityImageURL = securityImageURL;
    }

    public SecurityImages toEntity() {
        return new SecurityImages(this.id, this.securityImageName, this.securityImageURL);
    }
}
