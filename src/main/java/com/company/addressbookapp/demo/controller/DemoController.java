package com.company.addressbookapp.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class DemoController {

    // message by using get request
    @GetMapping
    public ResponseEntity<String> getMethod(){
        return ResponseEntity.ok("Get Request Successful");
    }

    //message by using id
    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id){
        return ResponseEntity.ok("Get Request by ID: "+id);
    }

    //post method
    @PostMapping
    public ResponseEntity<String> postMethod(){
        return ResponseEntity.ok("Post Request Successful");
    }

    // putting id to get value
    @PutMapping("/{id}")
    public ResponseEntity<String> putMethod(@PathVariable Long id){
        return ResponseEntity.ok("Put Request for ID: " + id);
    }

    //deleting by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMethod(@PathVariable Long id){
        return ResponseEntity.ok("Delete Request for Id : " + id);
    }

}
