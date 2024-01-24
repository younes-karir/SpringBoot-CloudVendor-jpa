package com.example.cloudvendorjpa.service;

import com.example.cloudvendorjpa.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor item);
    public String updateCloudVendor(CloudVendor item);
    public String deleteCloudVendor(long id);
    public CloudVendor getCloudVendor(long id);
    public List<CloudVendor> getAll ();
}
