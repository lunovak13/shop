package com.example.demo.Controller;

import com.example.demo.Model.Cart;
import com.example.demo.Model.Customer;
import com.example.demo.Model.Item;
import com.example.demo.Service.OrderService;
import com.example.demo.Service.CustomerService;
import com.example.demo.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private CustomerService customerService;


    // customers API

    @RequestMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @RequestMapping("/customers/{id}")
    public Optional<Customer> getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customers")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customers/{id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        customerService.updateCustomer(id, customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customers/{id}")
    public void DeleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }


    // items API

    @RequestMapping("/items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @RequestMapping("/items/{id}")
    public Optional<Item> getItem(@PathVariable Long id) {
        return itemService.getItem(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/items")
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/items/{id}")
    public void updateItem(@RequestBody Item item, @PathVariable Long id) {
        itemService.updateItem(id, item);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/items/{id}")
    public void DeleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }


    // cart API

    @RequestMapping(method = RequestMethod.POST, value = "customers/{customerId}/orders")
    public void addOrder(@RequestBody Cart cart, @PathVariable Long customerId) {
        orderService.addOrder(cart, customerId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "customers/{customerId}/orders/{orderId}")
    public void DeleteOrder(@PathVariable Long customerId, @PathVariable Long orderId) {
        orderService.deleteOrder(customerId, orderId);
    }


    // cart-item interaction API

    @RequestMapping(method = RequestMethod.POST, value = "/orders/{orderId}/items/{itemId}")
    public void addItemToOrder(@PathVariable Long orderId, @PathVariable Long itemId) {
        itemService.addItemToOrder(orderId, itemId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/orders/{orderId}/items/{itemId}")
    public void DeleteItemFromOrder(@PathVariable Long orderId, @PathVariable Long itemId) {
        itemService.deleteItemFromOrder(orderId, itemId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orders/{orderId}")
    public double getOrderTotal(@PathVariable Long orderId) {
        return orderService.getCartTotal(orderId);
    }

}
