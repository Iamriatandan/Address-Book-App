package com.company.addressbookapp.demo.controller;

import com.company.addressbookapp.demo.dto.AddressBookDTO;
import com.company.addressbookapp.demo.model.AddressBook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressBookController {
    //creating list to store entries
    private final List<AddressBook> addressBookList = new ArrayList<>();

    //create new Address
    @PostMapping
    public ResponseEntity<AddressBook> createAddress(@RequestBody AddressBookDTO addressBookDTO){
        AddressBook addressBook= new AddressBook(addressBookDTO.getName(),
                addressBookDTO.getEmail(),
                addressBookDTO.getPhoneNumber());
        addressBookList.add(addressBook);
        return ResponseEntity.ok(addressBook);
    }

    //get all address stored in list

    @GetMapping("/all")
    public ResponseEntity<List<AddressBookDTO>> getAllAddress(){
        List<AddressBookDTO> addressBookDTOList = new ArrayList<>();
        for(AddressBook address : addressBookList){
            addressBookDTOList.add(new AddressBookDTO(address.getName(),address.getEmail(),address.getPhoneNumber()));
        }
        return ResponseEntity.ok(addressBookDTOList);
    }

   @GetMapping("/{index}")
    public  ResponseEntity<AddressBookDTO> getAddressByIndex(@PathVariable int index){
        if(index >=0 && index<= addressBookList.size()){
            AddressBook addressBook = addressBookList.get(index);
            AddressBookDTO addressBookDTO = new AddressBookDTO(addressBook.getName(),addressBook.getEmail(),addressBook.getPhoneNumber());
            return ResponseEntity.ok(addressBookDTO);
        }
        return ResponseEntity.notFound().build();
   }

}
