package com.justice1k.phonebook.impl;

import com.justice1k.phonebook.Contact;
import com.justice1k.phonebook.ContactRepository;
import com.justice1k.phonebook.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public void createContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public Contact getContact(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteContact(Long id) {
        try{
            contactRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateContact(Long id, Contact contact) {
        Optional<Contact> contactOptional = contactRepository.findById(id);

        if (contactOptional.isPresent()){
            Contact newContact = contactOptional.get();
            newContact.setName(contact.getName());
            newContact.setNumber(contact.getNumber());
            contactRepository.save(newContact);
            return true;
        }
        return false;
    }
}
