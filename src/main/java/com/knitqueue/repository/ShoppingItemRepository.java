package com.knitqueue.repository;

import com.knitqueue.entity.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Integer> {
    
}
