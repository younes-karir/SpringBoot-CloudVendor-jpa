package com.example.cloudvendorjpa.repository;

import com.example.cloudvendorjpa.model.CloudVendor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloudVendorRepository  extends JpaRepository<CloudVendor, String> {

    List<CloudVendor> findAllByVendorName(String name);

}
