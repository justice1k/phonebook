package com.justice1k.phonebook;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();
    void createContact(Contact contact);
    Contact getContact(Long id);
    boolean deleteContact(Long id);
    boolean updateContact(Long id, Contact contact);

}
