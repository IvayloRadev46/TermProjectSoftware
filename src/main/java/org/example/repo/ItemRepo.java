package org.example.repo;

import org.example.models.Item;
import org.example.util.Database;

import java.util.ArrayList;
import java.util.List;

public class ItemRepo {

    public void save(Item item) {
        Database.items.add(item);
    }

    public List<Item> findAll() {
        return Database.items;
    }

    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();

        for (Item item : Database.items) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(item);
            }
        }

        return result;
    }

    public List<Item> findByCategory(String category) {
        List<Item> result = new ArrayList<>();

        for (Item item : Database.items) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                result.add(item);
            }
        }

        return result;
    }
}