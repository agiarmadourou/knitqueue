package com.knitqueue.service;

import com.knitqueue.entity.ShoppingItem;

import java.util.List;

public interface ShoppingItemService {
    ShoppingItem save(ShoppingItem shoppingItem);
    void delete(ShoppingItem shoppingItem);
    ShoppingItem findById(int id);
    List<ShoppingItem> findAll();


}
