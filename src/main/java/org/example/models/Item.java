package org.example.models;

public class Item {

    private String name;
    private String category;
    private int quantity;
    private String location;
    private String ownerEmail;

    public Item(String name, String category, int quantity, String location, String ownerEmail) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.location = location;
        this.ownerEmail = ownerEmail;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getLocation() {
        return location;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }
}