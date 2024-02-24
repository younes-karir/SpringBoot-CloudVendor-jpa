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


import static org.assertj.core.api.Assertions.*;

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

    @AfterEach
    void tearDown() {
        cloudVendor= null;
        cloudVendorRepository.deleteAll();
    }

    // test case success


    @Test
    void testFindVendorByName_Found()
    {
       List<CloudVendor> vendorList = cloudVendorRepository.findAllByVendorName("younes");
        assertThat(vendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(vendorList.getFirst().getVendorName()).isEqualTo(cloudVendor.getVendorName());
    }


    // test case failure


    @Test
    void testFindVendorByName_NotFound(){
        List<CloudVendor> vendorList = cloudVendorRepository.findAllByVendorName("khalid");
        assertThat(vendorList.isEmpty()).isFalse();
    }


}
