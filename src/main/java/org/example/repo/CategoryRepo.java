package org.example.repo;

import org.example.models.Category;
import org.example.util.Database;

public class CategoryRepo {

    public boolean existsByName(String categoryName) {
        for (Category category : Database.categories) {
            if (category.getName().equalsIgnoreCase(categoryName)) {
                return true;
            }
        }

        return false;
    }
}