package com.example.cloudvendorjpa.controller;
import com.example.cloudvendorjpa.model.CloudVendor;
import com.example.cloudvendorjpa.response.ResponseHandler;
import com.example.cloudvendorjpa.service.CloudVendorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Vector;

@RestController
@AllArgsConstructor
@RequestMapping("/cloud-vendor")
public class CloudVendorController {

    // Cloud vendor service
    CloudVendorService cloudVendorService;


    @PostMapping
    public ResponseEntity<Object>  createCloudVendor (@RequestBody CloudVendor item){
        return ResponseHandler.responseBuilder(
                "vendor list",
                HttpStatus.CREATED,
                cloudVendorService.createCloudVendor(item)
        );

    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return ResponseHandler.responseBuilder(
                "vendor list",
                HttpStatus.OK,
                cloudVendorService.getAll()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getCloudVendor (@PathVariable String id){

        return ResponseHandler.responseBuilder(
                "requested vendor details are given here ",
                HttpStatus.OK,
                cloudVendorService.getCloudVendor(id)
        );
    }

    @PutMapping
    public String updateCloudVendor(@RequestBody CloudVendor item){
        return cloudVendorService.updateCloudVendor(item);
    }


    @DeleteMapping("{id}")
    public String deleteCloudVendor (@PathVariable String id){
        return cloudVendorService.deleteCloudVendor(id);
    }


}
