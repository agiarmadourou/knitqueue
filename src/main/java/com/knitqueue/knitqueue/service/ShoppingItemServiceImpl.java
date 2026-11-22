package com.knitqueue.knitqueue.service;

import com.knitqueue.knitqueue.entity.AppUser;
import com.knitqueue.knitqueue.entity.Project;
import com.knitqueue.knitqueue.entity.ShoppingItem;
import com.knitqueue.knitqueue.repository.ProjectRepository;
import com.knitqueue.knitqueue.repository.ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingItemServiceImpl implements ShoppingItemService {
    private final ShoppingItemRepository shoppingItemRepository;
    private final ProjectRepository projectRepository;


    @Autowired
    public ShoppingItemServiceImpl(ShoppingItemRepository theShoppingItemRepository, ProjectRepository theProjectRepository) {
        shoppingItemRepository = theShoppingItemRepository;
        projectRepository = theProjectRepository;
    }


    @Override
    public ShoppingItem save(ShoppingItem shoppingItem) {
        int projectId = shoppingItem.getProject().getProjectId();
        int userId=shoppingItem.getAppUser().getUserId();

        Project theProject = projectRepository.findByProjectIdAndAppUser_UserId(projectId,userId)
                .orElseThrow(()->
                new IllegalArgumentException("Project not found or does not belong to this user."));
        shoppingItem.setProject(theProject);

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
