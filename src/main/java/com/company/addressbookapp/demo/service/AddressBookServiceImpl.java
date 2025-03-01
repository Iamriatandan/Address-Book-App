package com.company.addressbookapp.demo.service;

import com.company.addressbookapp.demo.dto.AddressBookDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServiceImpl implements AddressBookService{

    //Giving all logical code work in service class
    //Creating list
    private final List<AddressBookDTO> addressBookDTOList = new ArrayList<>();

    //Overriding method to add address
    @Override
    public AddressBookDTO addAddress(AddressBookDTO addressBookDTO){
        addressBookDTOList.add(addressBookDTO);
        return addressBookDTO;
    }

    //Overriding method to display all address
    @Override
    public List<AddressBookDTO> getAllAddresses(){
        return addressBookDTOList;
    }

    //Overriding Method to get address by index
    @Override
    public AddressBookDTO getAddressByIndex(int index){
        if(index >=0 && index <= addressBookDTOList.size()){
            return addressBookDTOList.get(index);
        }
        return null;
    }

    //Overriding Method to update address by index
    @Override
    public AddressBookDTO updateAddress(int index, AddressBookDTO addressBookDTO){
        if(index >=0 && index <= addressBookDTOList.size()){
            addressBookDTOList.set(index,addressBookDTO);
            return addressBookDTO;
        }
        return null;
    }

    //Overriding method to delete address
    @Override
    public void deleteAddress(int index){
        addressBookDTOList.remove(index);
    }
}
