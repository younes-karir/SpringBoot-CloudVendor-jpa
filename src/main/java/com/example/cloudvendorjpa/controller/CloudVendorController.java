package com.example.cloudvendorjpa.controller;
import com.example.cloudvendorjpa.model.CloudVendor;
import com.example.cloudvendorjpa.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping
    public String addItem (@RequestBody CloudVendor item){return cloudVendorService.createCloudVendor(item);}


    @GetMapping("")
    public List<CloudVendor> getAll(){
        return cloudVendorService.getAll();
    }

    @GetMapping("{id}")
    public CloudVendor getCloudVendor (@PathVariable long id){
        return cloudVendorService.getCloudVendor(id);
    }

    @PutMapping
    public String updateCloudVendor(@RequestBody CloudVendor item){
        return cloudVendorService.updateCloudVendor(item);
    }


    @DeleteMapping("{id}")
    public String deleteCloudVendor (@PathVariable long id){
        return cloudVendorService.deleteCloudVendor(id);
    }


}
