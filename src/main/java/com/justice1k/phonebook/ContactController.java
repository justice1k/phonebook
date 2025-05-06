package com.justice1k.phonebook;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class ContactController {

    @Autowired
    private final ContactService contactService;

    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<Contact>> findAll(){
        return ResponseEntity.ok(contactService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable @Positive Long id){
        Contact contact = contactService.getContact(id);
        if (contact != null){
            return ResponseEntity.status(HttpStatus.OK).body(contact);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Contact> addContact(@Valid @RequestBody Contact contact){
        contactService.createContact(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(contact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable @Positive Long id){
        boolean deleted = contactService.deleteContact(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@PathVariable @Positive Long id, @RequestBody @Valid Contact contact){
        boolean updated = contactService.updateContact(id, contact);
        if (updated){
            return new ResponseEntity<>("Contact updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed to update contact", HttpStatus.NOT_FOUND);
    }

}
