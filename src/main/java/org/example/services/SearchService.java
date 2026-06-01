package org.example.services;

import org.example.models.Item;
import org.example.repo.ItemRepo;

import java.util.List;

public class SearchService {

    private final ItemRepo itemRepo = new ItemRepo();

    public String searchByName(String name) {
        if (name == null || name.isBlank()) {
            return "Моля въведете име за търсене";
        }

        List<Item> items = itemRepo.findByName(name);

        if (items.isEmpty()) {
            return "Няма намерени предмети";
        }

        return "Намерени са предмети";
    }

    public String searchByCategory(String category) {
        if (category == null || category.isBlank()) {
            return "Моля въведете категория";
        }

        List<Item> items = itemRepo.findByCategory(category);

        if (items.isEmpty()) {
            return "Няма предмети в тази категория";
        }

        return "Намерени са предмети";
    }
}