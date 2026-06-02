package org.example.repo;

import org.example.models.ShoppingListItem;
import org.example.util.Database;

public class ShoppingListRepo {

    public void add(ShoppingListItem item) {
        Database.shoppingListItems.add(item);
    }

    public ShoppingListItem findByProductName(String productName) {
        for (ShoppingListItem item : Database.shoppingListItems) {
            if (item.getProductName().equalsIgnoreCase(productName)) {
                return item;
            }
        }

        return null;
    }
}