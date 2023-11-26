package com.education.ztu;

public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Pr. #" + id + " - " + name + " - $" +price);
    }

    @Override
    public int compareTo(Product otherProduct) {
        // Реалізація порівняння для сортування
        return Double.compare(this.price, otherProduct.price);
    }
}
