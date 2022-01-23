package com.example.demo.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CART")
public class Cart {

    @Id
    private Long id;

    @ManyToMany
    private List<Item> items;

    @ManyToOne
    //FIXME: @NotNull
    private Customer customer;


    public Cart() {
    }

    public Cart(Long id) {
        this.id = id;

    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
