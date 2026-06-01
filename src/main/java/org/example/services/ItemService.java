package org.example.services;

import org.example.models.Item;
import org.example.repo.CategoryRepo;
import org.example.repo.ItemRepo;
import org.example.repo.UserRepo;

public class ItemService {

    private final ItemRepo itemRepo = new ItemRepo();
    private final UserRepo userRepo = new UserRepo();
    private final CategoryRepo categoryRepo = new CategoryRepo();

    public String addItem(String name, String category, int quantity, String location, String ownerEmail) {
        if (ownerEmail == null || userRepo.findByEmail(ownerEmail) == null) {
            return "Потребителят не съществува";
        }

        if (name == null || name.isBlank()) {
            return "Името на предмета е задължително";
        }

        if (category == null || category.isBlank()) {
            return "Категорията е задължителна";
        }

        if (!categoryRepo.existsByName(category)) {
            return "Категорията не съществува";
        }

        if (quantity <= 0) {
            return "Количеството трябва да бъде положително";
        }

        if (location == null || location.isBlank()) {
            return "Местоположението е задължително";
        }

        Item item = new Item(name, category, quantity, location, ownerEmail);
        itemRepo.save(item);

        return "Предметът е добавен успешно";
    }
}