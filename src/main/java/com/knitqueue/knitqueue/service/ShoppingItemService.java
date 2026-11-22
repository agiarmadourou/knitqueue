package com.knitqueue.knitqueue.service;

import com.knitqueue.knitqueue.entity.AppUser;
import com.knitqueue.knitqueue.entity.Project;
import com.knitqueue.knitqueue.entity.ShoppingItem;

import java.util.List;

public interface ShoppingItemService {
    ShoppingItem save(ShoppingItem shoppingItem);
    void delete(ShoppingItem shoppingItem);
    ShoppingItem findById(int id);
    List<ShoppingItem> findAll();


}
