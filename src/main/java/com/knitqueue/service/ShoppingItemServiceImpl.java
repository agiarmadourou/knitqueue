package com.knitqueue.service;

import com.knitqueue.entity.Project;
import com.knitqueue.entity.ShoppingItem;
import com.knitqueue.repository.ProjectRepository;
import com.knitqueue.repository.ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public ShoppingItem update(int shoppingItemId, Map<String, String> changes) {
        // Retrieve the existing shopping item
        ShoppingItem theItem = findById(shoppingItemId);
        int userId = theItem.getAppUser().getUserId();

        // Allowed fields
        Set<String> allowedFields = Set.of(
                "projectId",
                "description",
                "purchaseUrl",
                "isPurchased"
        );

        if (!allowedFields.containsAll(changes.keySet())) {
            throw new IllegalArgumentException("Invalid field in update request.");
        }

        // Update project association
        if (changes.containsKey("projectId")) {
            String newProjectId = changes.get("projectId");

            if (newProjectId == null) {
                // Remove project association
                theItem.setProject(null);
            } else {
                // Find the project only if it belongs to the item's owner
                int projectId = Integer.parseInt(changes.get("projectId"));
                Project theProject = projectRepository.findByProjectIdAndAppUser_UserId(projectId, userId)
                                    .orElseThrow(() -> new IllegalArgumentException(
                                        "Project not found or does not belong to this user."));
                theItem.setProject(theProject);
            }
        }

        // Update other editable fields
        if (changes.containsKey("description")) {
            theItem.setDescription(changes.get("description"));
        }

        if (changes.containsKey("purchaseUrl")) {
            theItem.setPurchaseUrl(changes.get("purchaseUrl"));
        }

        if (changes.containsKey("isPurchased")) {
            String value = changes.get("isPurchased");
            if (!"true".equalsIgnoreCase(value) &&! "false".equalsIgnoreCase(value)){
                throw new IllegalArgumentException("isPurchased must be true or false.");
            }
        theItem.setPurchased(Boolean.parseBoolean(value));
        }

        return shoppingItemRepository.save(theItem);
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

    @Override
    public List<ShoppingItem> retrieveUserShoppingList(int userId) {
        return shoppingItemRepository.findByAppUser_UserId(userId);
    }

    @Override
    public List<ShoppingItem> retrieveProjectShoppingItems(int projectId) {
        return shoppingItemRepository.findByProject_ProjectId(projectId);
    }


}
