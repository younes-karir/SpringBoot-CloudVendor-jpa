package com.example.cloudvendorjpa.service;

import com.example.cloudvendorjpa.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor item);
    public String updateCloudVendor(CloudVendor item);
    public String deleteCloudVendor(String id);
    public CloudVendor getCloudVendor(String id);
    public CloudVendor getByVendorName(String name);
    public List<CloudVendor> getAll ();
}
