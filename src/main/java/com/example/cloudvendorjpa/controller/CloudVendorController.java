package com.example.cloudvendorjpa.controller;
import com.example.cloudvendorjpa.model.CloudVendor;
import com.example.cloudvendorjpa.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;
import java.util.Vector;






@RestController
@RequestMapping("/cloud-vendor")
public class CloudVendorController {
    Vector<CloudVendor> data = new Vector<CloudVendor>();

    // Cloud vendor service

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("{id}")
    public CloudVendor GetItem(@PathVariable("id") long id){
        for (CloudVendor item: data) {
            if(item.getVendorId() == id)
                return item;
        }
    return null;
    }


    @PostMapping
    public String addItem (@RequestBody CloudVendor item){return cloudVendorService.createCloudVendor(item);}




}
