//package com.mob.casestudy.digitalbanking.controller;
//
//import com.mob.casestudy.digitalbanking.entity.SecurityImages;
//import com.mob.casestudy.digitalbanking.exception.ImageNotFoundException;
//import com.mob.casestudy.digitalbanking.service.SecurityImageService;
//import openapi.model.GetSecurityImagesResponseDto;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@ExtendWith(MockitoExtension.class)
//class SecurityImageControllerTest {
//
//    @InjectMocks
//    ServiceController securityImageController;
//    @Mock
//    SecurityImageService securityImageService;
////
//    @Test
//    void getList() {
//        SecurityImages securityImages = new SecurityImages();
//        List<SecurityImages> securityImagesList = new ArrayList<>();
//        securityImagesList.add(securityImages);
//        GetSecurityImagesResponseDto expectedObject = new GetSecurityImagesResponseDto();
//        expectedObject.addSecurityImagesItem(securityImages.toDto());
//        ResponseEntity<GetSecurityImagesResponseDto> expectedResponseEntity = new ResponseEntity<>(expectedObject, HttpStatus.OK);
//        Mockito.when(securityImageService.findAll()).thenReturn(securityImagesList);
//        org.assertj.core.api.Assertions.assertThat(expectedResponseEntity).usingRecursiveComparison().isEqualTo(securityImagesList);
//    }
//
//    @Test
//    void getList_nullList_throwsException() {
//        List<SecurityImages> list = null;
//            Mockito.when(securityImageService.findAll()).thenReturn(list);
//            Assertions.assertThrows(ImageNotFoundException.class, () -> securityImageService.getAllSecurityImages());
//    }
//
////    @Test
////    void getList_emptyList_throwsException() {
////        List<SecurityImages> list = new ArrayList<>();
////        Mockito.when(securityImageService.findAll()).thenReturn(list);
////        Assertions.assertThrows(ImageNotFoundException.class, () -> securityImageService.getAllSecurityImages());
////    }
//}