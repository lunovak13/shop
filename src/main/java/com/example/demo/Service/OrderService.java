package com.example.demo.Service;

import com.example.demo.Model.Cart;
import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public void addOrder(Cart cart, Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        customer.map(c -> c.getCarts()).get().add(cart);

        orderRepository.save(cart);
    }

    public void deleteOrder(Long customerId, Long orderId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        customer.map(c -> c.getCarts()).get().removeIf(c -> c.getId().equals(orderId));

        orderRepository.deleteById(orderId);
        customerRepository.save(customer.get());
    }

    public double getCartTotal(Long orderId) {
        Optional<Cart> cart = orderRepository.findById(orderId);
        return cart.get().getItems().stream().map(i -> i.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
    }


}
