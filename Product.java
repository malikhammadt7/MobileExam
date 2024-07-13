package com.example.mobileexam;

public class Product {

    private String name;
    private String category;
    private double price;
    private int imageResourceId;

    public Product(String name, String category, double price, int imageResourceId) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}