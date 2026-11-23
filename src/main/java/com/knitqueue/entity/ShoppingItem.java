package com.knitqueue.entity;

import jakarta.persistence.*;

@Entity
@Table(name="shopping_item")
public class ShoppingItem {
    // Fields
    @Id
    @Column(name="shopping_item_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int shoppingItemId;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name="user_id")
    private AppUser appUser;

    @Column(name="description")
    private String description;

    @Column(name="purchase_url")
    private String purchaseUrl;

    @Column(name="is_purchased")
    private boolean isPurchased;

    // Constructors
    public ShoppingItem() {}

    public ShoppingItem(Project project, AppUser appUser, String description, String purchaseUrl,
                        boolean isPurchased) {
        this.project = project;
        this.appUser = appUser;
        this.description = description;
        this.purchaseUrl = purchaseUrl;
        this.isPurchased = isPurchased;
    }

    // Getters and Setters
    public int getShoppingItemId() {
        return shoppingItemId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPurchaseUrl() {
        return purchaseUrl;
    }

    public void setPurchaseUrl(String purchaseUrl) {
        this.purchaseUrl = purchaseUrl;
    }

    public boolean isPurchased() {
        return isPurchased;
    }

    public void setPurchased(boolean purchased) {
        isPurchased = purchased;
    }

    // toString

    @Override
    public String toString() {
        return "ShoppingItem{" +
                "shoppingItemId=" + shoppingItemId +
                ", project=" + project +
                ", appUser=" + appUser +
                ", description='" + description + '\'' +
                ", purchaseUrl='" + purchaseUrl + '\'' +
                ", isPurchased=" + isPurchased +
                '}';
    }
}
