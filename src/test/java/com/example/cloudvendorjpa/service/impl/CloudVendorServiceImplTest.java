package com.example.cloudvendorjpa.service.impl;

import com.example.cloudvendorjpa.model.CloudVendor;
import com.example.cloudvendorjpa.repository.CloudVendorRepository;
import com.example.cloudvendorjpa.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class CloudVendorServiceImplTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;
    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this); //
        cloudVendorService =  new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor = CloudVendor.builder().vendorId("id6723").vendorAddress("beni mellal")
                .vendorName("younes karir")
                .vendorPhoneNumber("06608643421")
                .build();
    }
    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }




    @Test
    void teatCreateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("Success");
    }

    @Test
    void testUpdateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.updateCloudVendor(CloudVendor.builder()
                        .vendorName("khalid fatihi")
                        .vendorAddress("casablanca")
                        .vendorPhoneNumber("067253689")
                .build())).isEqualTo("Success");
    }
    @Test
    void deleteCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);
        doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository).deleteById(any());
        assertThat(cloudVendorService.deleteCloudVendor("id6723")).isEqualTo("Success");
    }

    @Test
    void TestGetCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.findById("id6723")).thenReturn(Optional.ofNullable(cloudVendor));
        assertThat(cloudVendorService.getCloudVendor("id6723").getVendorName())
                .isEqualTo(cloudVendor.getVendorName());
    }


    @Test
    void testGetByVendorName(){
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.findAllByVendorName("younes karir")).thenReturn(
                new ArrayList<CloudVendor>(Collections.singleton(cloudVendor))
        );
        assertThat(cloudVendorRepository.findAllByVendorName("younes karir").getFirst().getVendorId())
                .isEqualTo(cloudVendor.getVendorId());
    }

    @Test
    void getAll() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.findAll()).thenReturn(
                new ArrayList<CloudVendor>(Collections.singleton(cloudVendor))
        );
        assertThat(cloudVendorRepository.findAll().getFirst().getVendorPhoneNumber())
                .isEqualTo(cloudVendor.getVendorPhoneNumber());
    }
}