package com.company.addressbookapp.demo.service;

import com.company.addressbookapp.demo.dto.AddressBookDTO;

import java.util.List;

public interface AddressBookService {

    //Methods To do respective tasks

    //Method to add address
    AddressBookDTO addAddress(AddressBookDTO addressBookDTO);

    //Method to get all Address in list

    List<AddressBookDTO> getAllAddresses();

    //Method to get address by index
    AddressBookDTO getAddressByIndex(int index);

    //Method to update address by index
    AddressBookDTO updateAddress(int index, AddressBookDTO addressBookDTO);

    //method to delete address
    void deleteAddress(int index);
}
