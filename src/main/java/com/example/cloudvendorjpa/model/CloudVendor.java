package com.example.cloudvendorjpa.model;


import jakarta.persistence.*;

@Entity
@Table(name = "vendors")
public class CloudVendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long  VendorId;

    @Column(name = "name")
    private String VendorName;

    @Column(name = "address")
    private String VendorAddress;

    @Column(name = "phone-number")
    private String VendorPhoneNumber;


    public CloudVendor() {
    }

    public CloudVendor(long vendorId, String vendorName, String vendorAddress, String vendorPhoneNumber) {
        VendorId = vendorId;
        VendorName = vendorName;
        VendorAddress = vendorAddress;
        VendorPhoneNumber = vendorPhoneNumber;
    }

    public long getVendorId() {
        return VendorId;
    }

    public String getVendorName() {
        return VendorName;
    }

    public String getVendorAddress() {
        return VendorAddress;
    }

    public String getVendorPhoneNumber() {
        return VendorPhoneNumber;
    }

    public void setVendorId(long vendorId) {
        VendorId = vendorId;
    }

    public void setVendorName(String vendorName) {
        VendorName = vendorName;
    }

    public void setVendorAddress(String vendorAddress) {
        VendorAddress = vendorAddress;
    }

    public void setVendorPhoneNumber(String vendorPhoneNumber) {
        VendorPhoneNumber = vendorPhoneNumber;
    }
}
