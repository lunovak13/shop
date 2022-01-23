package com.example.demo.Model;

import com.example.demo.Model.Cart;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    private BigInteger phoneNumber;


    @OneToMany
    @JoinColumn(name = "CUSTOMER_ID")
    //FIXME: cascade
    private List<Cart> carts;

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, String mail, BigInteger phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.carts = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public BigInteger getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(BigInteger phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
