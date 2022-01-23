package com.example.demo.Service;

import com.example.demo.Model.Cart;
import com.example.demo.Model.Item;
import com.example.demo.Repository.ItemRepository;
import com.example.demo.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {


    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository cartRepository;

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        itemRepository.findAll().forEach(items::add);
        return items;
    }

    public Optional<Item> getItem(Long id) {
        return itemRepository.findById(id);
    }


    public void addItem(Item item) {
        itemRepository.save(item);
    }


    public void updateItem(Long id, Item item) {
        itemRepository.save(item);
    }


    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public void addItemToOrder(Long orderId, Long itemId) {
        Optional<Item> item = itemRepository.findById(itemId);
        Optional<Cart> cart = cartRepository.findById(orderId);
        cart.map(c -> c.getItems()).get().add(item.get());

        cartRepository.save(cart.get());
    }

    public void deleteItemFromOrder(Long orderId, Long itemId) {
        Optional<Cart> order = cartRepository.findById(orderId);
        order.map(c -> c.getItems()).get().removeIf(c -> c.getId().equals(itemId));

        itemRepository.deleteById(itemId);
        cartRepository.save(order.get());
    }


}
