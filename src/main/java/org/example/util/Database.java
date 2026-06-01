package org.example.util;

import org.example.models.Category;
import org.example.models.Item;
import org.example.models.User;

import java.util.ArrayList;
import java.util.List;

public class Database {

    public static final List<User> users = new ArrayList<>();
    public static final List<Item> items = new ArrayList<>();
    public static final List<Category> categories = new ArrayList<>();

    public static void reset() {
        users.clear();
        items.clear();
        categories.clear();

        users.add(new User("user@test.com", "123456", "USER"));
        users.add(new User("admin@test.com", "admin123", "ADMIN"));

        categories.add(new Category("Уреди"));
        categories.add(new Category("Храна"));
        categories.add(new Category("Почистващи"));

        items.add(new Item("Прахосмукачка", "Уреди", 1, "Килер", "user@test.com"));
        items.add(new Item("Ориз", "Храна", 2, "Кухня", "user@test.com"));
        items.add(new Item("Препарат", "Почистващи", 1, "Баня", "admin@test.com"));
    }
}