package com.justice1k.phonebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class ContactController {

    @Autowired
    ContactService contactService;

    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @GetMapping("")
    public ResponseEntity<List<Contact>> findAll(){
        return new ResponseEntity<>(contactService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id){
        Contact contact = contactService.getContact(id);
        if (contact != null){
            return ResponseEntity.status(HttpStatus.OK).body(contact);
        }

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping("")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
        contactService.createContact(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(contact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id){
        boolean deleted = contactService.deleteContact(id);

        if (deleted){
            return new ResponseEntity<>("Contact deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@PathVariable Long id, @RequestBody Contact contact){
        boolean updated = contactService.updateContact(id, contact);
        if (updated){
            return new ResponseEntity<>("Contact updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed to update contact", HttpStatus.NOT_FOUND);
    }

}
