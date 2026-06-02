package org.example.util;

import org.example.models.Category;
import org.example.models.Item;
import org.example.models.ShoppingListItem;
import org.example.models.User;

import java.util.ArrayList;
import java.util.List;

public class Database {

    public static final List<User> users = new ArrayList<>();
    public static final List<Item> items = new ArrayList<>();
    public static final List<Category> categories = new ArrayList<>();
    public static final List<ShoppingListItem> shoppingListItems = new ArrayList<>();

    public static void reset() {
        users.clear();
        items.clear();
        categories.clear();
        shoppingListItems.clear();

        users.add(new User("user@test.com", "123456", "MEMBER"));
        users.add(new User("owner@test.com", "owner123", "OWNER"));

        categories.add(new Category("Уреди"));
        categories.add(new Category("Храна"));
        categories.add(new Category("Почистващи"));

        items.add(new Item("Прахосмукачка", "Уреди", 1, "Килер", "user@test.com"));
        items.add(new Item("Ориз", "Храна", 2, "Кухня", "user@test.com"));
        items.add(new Item("Препарат", "Почистващи", 1, "Баня", "owner@test.com"));
    }
}