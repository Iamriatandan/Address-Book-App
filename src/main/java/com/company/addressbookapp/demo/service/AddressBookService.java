package com.company.addressbookapp.demo.service;

import com.company.addressbookapp.demo.dto.ContactDTO;

import java.util.List;

public interface AddressBookService {
    ContactDTO addContact(ContactDTO contactDTO);
    List<ContactDTO> getAllContacts();
    ContactDTO getContactById(Long id);
    ContactDTO updateContact(Long id, ContactDTO contactDTO);
    void deleteContact(Long id);
}
