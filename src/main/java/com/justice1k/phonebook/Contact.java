package com.justice1k.phonebook;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    @NotNull
    private String number;

    public Contact() {
    }

    public Contact(Long id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String phone) {
        this.number = phone;
    }
}
