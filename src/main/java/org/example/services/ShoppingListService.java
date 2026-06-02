package org.example.services;

import org.example.models.Item;
import org.example.models.ShoppingListItem;
import org.example.repo.ItemRepo;
import org.example.repo.ShoppingListRepo;

import java.util.List;

public class ShoppingListService {

    private final ItemRepo itemRepo = new ItemRepo();
    private final ShoppingListRepo shoppingListRepo = new ShoppingListRepo();

    public String addToShoppingList(String productName, int quantity) {
        if (productName == null || productName.isBlank()) {
            return "Името на продукта е задължително";
        }

        if (quantity <= 0) {
            return "Количеството трябва да бъде положително";
        }

        List<Item> existingItems = itemRepo.findByName(productName);

        if (existingItems.isEmpty()) {
            return "Продуктът не съществува в инвентара";
        }

        ShoppingListItem existingShoppingItem = shoppingListRepo.findByProductName(productName);

        if (existingShoppingItem != null) {
            return "Продуктът вече е в списъка";
        }

        ShoppingListItem item = new ShoppingListItem(productName, quantity);
        shoppingListRepo.add(item);

        return "Продуктът е добавен в списъка за пазаруване";
    }

    public String markAsPurchased(String productName) {
        if (productName == null || productName.isBlank()) {
            return "Името на продукта е задължително";
        }

        ShoppingListItem item = shoppingListRepo.findByProductName(productName);

        if (item == null) {
            return "Продуктът не е намерен в списъка";
        }

        item.markAsPurchased();

        return "Продуктът е маркиран като закупен";
    }
}