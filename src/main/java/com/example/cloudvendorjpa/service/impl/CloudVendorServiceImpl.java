package com.example.cloudvendorjpa.service.impl;

import com.example.cloudvendorjpa.model.CloudVendor;
import com.example.cloudvendorjpa.repository.CloudVendorRepository;
import com.example.cloudvendorjpa.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor item) {
        cloudVendorRepository.save(item);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor item) {
        cloudVendorRepository.save(item);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(long id) {
        cloudVendorRepository.deleteById(id);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(long id) {
        return cloudVendorRepository.findById(id).get();
    }

    @Override
    public List<CloudVendor> getAll() {
        return cloudVendorRepository.findAll();
    }



}
