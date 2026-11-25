package com.knitqueue.repository;

import com.knitqueue.entity.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Integer> {
    List<ShoppingItem> findByAppUser_UserId(int userId);
    List<ShoppingItem> findByProject_ProjectId(int projectId);
}
