//package com.mob.casestudy.digitalbanking.controller;
//
//import com.mob.casestudy.digitalbanking.service.CustomerOtpService;
//import com.mob.casestudy.digitalbanking.service.CustomerSecurityImagesService;
//import com.mob.casestudy.digitalbanking.service.CustomerService;
//import com.mob.casestudy.digitalbanking.service.SecurityImageService;
//import openapi.model.CreateCustomerResponseDto;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(controllers = ClientController.class)
//public class ClientControllerTest {
//
//    @MockBean
//    CustomerSecurityImagesService customerSecurityImagesService;
//
//    @MockBean
//    SecurityImageService securityImageService;
//
//    @MockBean
//    CustomerOtpService customerOtpService;
//
//    @MockBean
//    CustomerService customerService;
//
//    @Autowired
//    MockMvc mockMvc;
//
//
//    @Test
//    public void testCreateCustomerAll() throws Exception {
//        ResponseEntity<CreateCustomerResponseDto> response = new ResponseEntity<>(HttpStatus.CREATED);
//        Mockito.when(customerService.postCustomers(Mockito.any())).thenReturn(response);
//
//        String body = " {\n" +
//                "     \"userName\" : \"Shreyaa15\",\n" +
//                "  \"firstName\": \"Shreya\",\n" +
//                "  \"lastName\": \"Gandhi\",\n" +
//                "  \"phoneNumber\": \"7567109811\",\n" +
//                "  \"email\": \"sgandhi@mobiquityinc.com\",\n" +
//                "  \"preferredLanguage\": \"EN\"\n" +
//                "}";
//        mockMvc.perform(post("http://localhost:8080/customer-service/client-api/v1/customers")
//                        .content(body))
//                .andExpect(status().isCreated());
//    }
//}
