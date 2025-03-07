package com.company.addressbookapp.demo.controller;
import com.company.addressbookapp.demo.dto.ContactDTO;
import com.company.addressbookapp.demo.service.AddressBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class AddressBookController {

    //Loose coupling
    private AddressBookService addressBookService;

    //Creating constructor
    public AddressBookController(AddressBookService addressBookService){
        this.addressBookService=addressBookService;
    }

    //Method to add contact
    @PostMapping
    public ResponseEntity<ContactDTO> addAddress(@RequestBody ContactDTO contactDTO){
        return ResponseEntity.ok(addressBookService.addContact(contactDTO));
    }

    //Method to get all contact
    @GetMapping
    public ResponseEntity<List<ContactDTO>> getAllAddress(){
        return ResponseEntity.ok(addressBookService.getAllContacts());
    }

    //Method to get contact by id
    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable Long id){
        ContactDTO contactDTO = addressBookService.getContactById(id);
        return contactDTO !=null? ResponseEntity.ok(contactDTO):ResponseEntity.notFound().build();
    }

    //Method to update contact by id
    @PutMapping("/{id}")
    public ResponseEntity<ContactDTO> updateContact(@PathVariable Long id, @RequestBody ContactDTO contactDTO){
        ContactDTO updateAddress = addressBookService.updateContact(id, contactDTO);
        return updateAddress!=null?ResponseEntity.ok(updateAddress):ResponseEntity.notFound().build();
    }

    //Method to delete contact by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id){
        addressBookService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
}
