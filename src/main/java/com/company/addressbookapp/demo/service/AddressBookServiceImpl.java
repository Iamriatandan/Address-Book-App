package com.company.addressbookapp.demo.service;

import com.company.addressbookapp.demo.dto.AddressBookDTO;
import com.company.addressbookapp.demo.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServiceImpl implements AddressBookService{

    //Giving all logical code work in service class
    //Creating list OF AddressBook class
    private final List<AddressBook> addressBookList = new ArrayList<>();

    //Overriding method to add address
    @Override
    public AddressBookDTO addAddress(AddressBookDTO addressBookDTO){
        AddressBook addressBook = new AddressBook(addressBookDTO.getName(),addressBookDTO.getEmail(),addressBookDTO.getPhoneNumber());
        addressBookList.add(addressBook);
        return addressBookDTO;
    }

    //Overriding method to display all address
    @Override
    public List<AddressBookDTO> getAllAddresses(){
        List<AddressBookDTO> dtoList = new ArrayList<>();
        for(AddressBook addressBook : addressBookList){
            dtoList.add(new AddressBookDTO(addressBook.getName(),addressBook.getEmail(),addressBook.getPhoneNumber()));
        }
        return dtoList;
    }

    //Overriding Method to get address by index
    @Override
    public AddressBookDTO getAddressByIndex(int index){
        if(index >=0 && index <= addressBookList.size()){
            AddressBook addressBook = addressBookList.get(index);
            return new AddressBookDTO(addressBook.getName(),addressBook.getEmail(),addressBook.getPhoneNumber());
        }
        return null;
    }

    //Overriding Method to update address by index
    @Override
    public AddressBookDTO updateAddress(int index, AddressBookDTO addressBookDTO){
        if(index >=0 && index <= addressBookList.size()){
            AddressBook addressBook = addressBookList.get(index);
            addressBook.setName(addressBookDTO.getName());
            addressBook.setEmail(addressBookDTO.getEmail());
            addressBook.setPhoneNumber(addressBookDTO.getPhoneNumber());
            return addressBookDTO;
        }
        return null;
    }

    //Overriding method to delete address
    @Override
    public void deleteAddress(int index){
        addressBookList.remove(index);
    }
}
