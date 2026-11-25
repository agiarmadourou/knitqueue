package com.knitqueue.service;

import com.knitqueue.entity.ShoppingItem;

import java.util.List;
import java.util.Map;

public interface ShoppingItemService {
    ShoppingItem save(ShoppingItem shoppingItem);
    ShoppingItem update(int shoppingItemId, Map<String, String> changes);
    void delete(ShoppingItem shoppingItem);
    ShoppingItem findById(int id);
    List<ShoppingItem> findAll();
    List<ShoppingItem> retrieveUserShoppingList(int userId);
    List<ShoppingItem> retrieveProjectShoppingItems(int projectId);

}
