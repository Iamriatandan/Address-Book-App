package com.company.addressbookapp.demo.service;
import com.company.addressbookapp.demo.dto.ContactDTO;
import com.company.addressbookapp.demo.model.Contact;
import com.company.addressbookapp.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class AddressBookServiceImpl implements AddressBookService{
    //Giving all logical code work in service class
    private static final Logger log = LoggerFactory.getLogger(AddressBookServiceImpl.class);
    @Autowired
    ContactRepository contactRepository;

    //Overriding method to save contact
    @Override
    public ContactDTO addContact(ContactDTO contactDTO){
        log.info("Adding new Contacts: {} ", contactDTO);
        Contact contact = new Contact(contactDTO.getName(), contactDTO.getEmail(), contactDTO.getPhoneNumber());
        Contact savedContact = contactRepository.save(contact);
        return convertToDTO(savedContact);
    }

    //Overriding method to display all contacts
    @Override
    public List<ContactDTO> getAllContacts(){
        log.info("Fetching all address");
        return contactRepository.findAll().stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //Overriding Method to get contact by id
    @Override
    public ContactDTO getContactById(Long id){
        log.info("Fetching contact with ID: {}",id);
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.map(this::convertToDTO).orElse(null);
    }

    //Overriding Method to update  contact by id
    @Override
    public ContactDTO updateContact(Long id, ContactDTO contactDTO){
        log.info("Updating contact with ID{}:{}",id,contactDTO);
        return contactRepository.findById(id).map(contact->{
            contact.setName(contactDTO.getName());
            contact.setEmail(contactDTO.getEmail());
            contact.setPhoneNumber(contactDTO.getPhoneNumber());
            Contact updatedContact = contactRepository.save(contact);
            return convertToDTO(updatedContact);
        }).orElse(null);
    }

    //Overriding method to delete contact by id
    @Override
    public void deleteContact(Long id) {
       if(contactRepository.existsById(id)){
           log.info("Deleting contact with ID{} :",id);
           contactRepository.deleteById(id);
       }
       else {
           log.warn("Contact with ID{} not found for deleting",id);
       }
    }

    //helper method to convert Entity to DTO
    private ContactDTO convertToDTO(Contact contact){
        return new ContactDTO(contact.getId(),contact.getName(), contact.getEmail(),contact.getPhoneNumber());
    }
}
