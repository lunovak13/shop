package com.example.demo.Repository;

import com.example.demo.Model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Cart, Long> {

}
