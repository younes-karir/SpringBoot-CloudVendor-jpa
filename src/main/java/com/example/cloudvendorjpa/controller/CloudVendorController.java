package com.example.cloudvendorjpa.controller;
import com.example.cloudvendorjpa.model.CloudVendor;
import org.springframework.web.bind.annotation.*;
import java.util.Vector;






@RestController
@RequestMapping("/cloud-vendor")
public class CloudVendorController {
    Vector<CloudVendor> data = new Vector<CloudVendor>();



    @GetMapping("{id}")
    public CloudVendor GetItem(@PathVariable long id){
        for (CloudVendor item: data) {
            if(item.getVendorId() == id)
                return item;
        }
    return null;
    }


    @PostMapping
    public String addItem (@RequestBody CloudVendor item){
        if(data.add(item)) return "item added with success"; else return "Error";
    }




}
