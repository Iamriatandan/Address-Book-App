package com.company.addressbookapp.demo.service;

import com.company.addressbookapp.demo.dto.AddressBookDTO;
import com.company.addressbookapp.demo.model.AddressBook;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class AddressBookServiceImpl implements AddressBookService{
    //Giving all logical code work in service class
    //Creating list OF AddressBook class
    private static final Logger log = LoggerFactory.getLogger(AddressBookServiceImpl.class);
    private final List<AddressBook> addressBookList = new ArrayList<>();

    //Overriding method to add address
    @Override
    public AddressBookDTO addAddress(AddressBookDTO addressBookDTO){
        log.info("Adding new Address: {} ",addressBookDTO);
        AddressBook addressBook = new AddressBook(addressBookDTO.getName(),addressBookDTO.getEmail(),addressBookDTO.getPhoneNumber());
        addressBookList.add(addressBook);
        return addressBookDTO;
    }

    //Overriding method to display all address
    @Override
    public List<AddressBookDTO> getAllAddresses(){
        log.info("Fetching all address");
        List<AddressBookDTO> dtoList = new ArrayList<>();
        for(AddressBook addressBook : addressBookList){
            dtoList.add(new AddressBookDTO(addressBook.getId(), addressBook.getName(),addressBook.getEmail(),addressBook.getPhoneNumber()));
        }
        return dtoList;
    }

    //Overriding Method to get address by index
    @Override
    public AddressBookDTO getAddressByIndex(int index){
        if(index >=0 && index < addressBookList.size()){
            log.info("Fetching address at index : {} ",index);
            AddressBook addressBook = addressBookList.get(index);
            return new AddressBookDTO(addressBook.getId(),addressBook.getName(),addressBook.getEmail(),addressBook.getPhoneNumber());
        }
        log.warn("Address at index {} not found ",index);
        return null;
    }

    //Overriding Method to update address by index
    @Override
    public AddressBookDTO updateAddress(int index, AddressBookDTO addressBookDTO){
        if(index >=0 && index < addressBookList.size()){
            AddressBook addressBook = addressBookList.get(index);
            log.info("Updating address at index{} : {} ",index,addressBookDTO);
            addressBook.setName(addressBookDTO.getName());
            addressBook.setEmail(addressBookDTO.getEmail());
            addressBook.setPhoneNumber(addressBookDTO.getPhoneNumber());
            return addressBookDTO;
        }
        log.warn("Address at index {} not found for update ",index);
        return null;
    }

    //Overriding method to delete address
    @Override
    public void deleteAddress(int index) {
        if (index >= 0 && index < addressBookList.size()) { // Fixed condition
            log.info("Deleting address at index {}", index);
            addressBookList.remove(index);
        } else {
            log.warn("Address at index {} not found for deleting", index);
        }
    }
}
