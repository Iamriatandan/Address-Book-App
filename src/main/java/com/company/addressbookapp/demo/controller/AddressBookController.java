package com.company.addressbookapp.demo.controller;
import com.company.addressbookapp.demo.dto.AddressBookDTO;
import com.company.addressbookapp.demo.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressBookController {

    //Loose coupling
    @Autowired
    private AddressBookService addressBookService;

    //Creating constructor
    public AddressBookController(@RequestBody AddressBookService addressBookService){
        this.addressBookService=addressBookService;
    }

    //Method to add address
    @PostMapping
    public ResponseEntity<AddressBookDTO> addAddress(AddressBookDTO addressBookDTO){
        return ResponseEntity.ok(addressBookService.addAddress(addressBookDTO));
    }

    //Method to get all address
    @GetMapping
    public ResponseEntity<List<AddressBookDTO>> getAllAddress(){
        return ResponseEntity.ok(addressBookService.getAllAddresses());
    }

    //Method to get address by index
    @GetMapping("/{index}")
    public ResponseEntity<AddressBookDTO> getAddressByIndex(@PathVariable int index){
        AddressBookDTO addressBookDTO = addressBookService.getAddressByIndex(index);
        return addressBookDTO !=null? ResponseEntity.ok(addressBookDTO):ResponseEntity.notFound().build();
    }

    //Method to update address by index
    @PutMapping("/{index}")
    public ResponseEntity<AddressBookDTO> updateAdressByIndex(@PathVariable int index,@RequestBody AddressBookDTO addressBookDTO){
        AddressBookDTO updateAddress = addressBookService.updateAddress(index,addressBookDTO);
        return updateAddress!=null?ResponseEntity.ok(updateAddress):ResponseEntity.notFound().build();
    }

    //Method to delete address by index
    @DeleteMapping("/{index}")
    public ResponseEntity<Void> deleteAddress(@PathVariable int index){
        addressBookService.deleteAddress(index);
        return ResponseEntity.noContent().build();
    }
}
