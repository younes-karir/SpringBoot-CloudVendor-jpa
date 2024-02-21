package com.example.cloudvendorjpa.repository;


import com.example.cloudvendorjpa.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
public class CloudVendorRepositoryTest {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;


    @BeforeEach
    void setUp() {
        cloudVendor =  CloudVendor.builder()
                .VendorName("younes")
                .VendorAddress("beni mellal")
                .VendorId(1)
                .VendorPhoneNumber("0660895757")
                .build();
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
        cloudVendor= null;
        cloudVendorRepository.deleteAll();
    }

    // test case success


    @Test
    void testFindVendorByName_Found()
    {
        List<CloudVendor> cloudVendors = cloudVendorRepository.findAllByVendorName("younes");

        }


    // test case failure
}
