package org.example.models;

public class ShoppingListItem {

    private String productName;
    private int quantity;
    private boolean purchased;

    public ShoppingListItem(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
        this.purchased = false;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void markAsPurchased() {
        this.purchased = true;
    }
}