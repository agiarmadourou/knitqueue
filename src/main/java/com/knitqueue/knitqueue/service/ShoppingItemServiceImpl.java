package com.knitqueue.knitqueue.service;

import com.knitqueue.knitqueue.entity.ShoppingItem;
import com.knitqueue.knitqueue.repository.ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingItemServiceImpl implements ShoppingItemService {
    private final ShoppingItemRepository shoppingItemRepository;

    @Autowired
    public ShoppingItemServiceImpl(ShoppingItemRepository theShoppingItemRepository) {
        shoppingItemRepository = theShoppingItemRepository;
    }


    @Override
    public ShoppingItem save(ShoppingItem shoppingItem) {
        return shoppingItemRepository.save(shoppingItem);
    }

    @Override
    public void delete(ShoppingItem shoppingItem) {
        shoppingItemRepository.delete(shoppingItem);
    }

    @Override
    public ShoppingItem findById(int id) {
        return shoppingItemRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Shopping item with id " + id + " not found."));
    }

    @Override
    public List<ShoppingItem> findAll() {
        return shoppingItemRepository.findAll();
    }


}
