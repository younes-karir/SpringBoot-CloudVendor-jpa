package com.example.cloudvendorjpa.repository;

import com.example.cloudvendorjpa.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository  extends JpaRepository<CloudVendor, Long> {
}
