package com.example.cloudvendorjpa.repository;


import com.example.cloudvendorjpa.model.CloudVendor;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class CloudVendorRepositoryTest {


    @Autowired
    CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;



    @BeforeEach
    void setUp() {
        cloudVendor =  CloudVendor.builder()
                .vendorName("younes")
                .vendorId("1")
                .vendorAddress("beni mellal")
                .vendorPhoneNumber("0660895757")
                .build();
        cloudVendorRepository.save(cloudVendor);
    }
    // test case success


    @Test
    void testFindVendorByName_Found()
    {
       List<CloudVendor> vendorList = cloudVendorRepository.findAllByVendorName("younes");
        System.out.println(vendorList.get(0).getVendorName());
    }


    // test case failure
    @AfterEach
    void tearDown() {
        cloudVendor= null;
        cloudVendorRepository.deleteAll();
    }


}
