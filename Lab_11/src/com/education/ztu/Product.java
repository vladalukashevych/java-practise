package com.education.ztu;

public class Product {
    private int id;
    private String name;
    private int count;
    private String category;
    private String brand;

    public Product() {
    }

    public Product(int id, String name, int count, String category, String brand) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.category = category;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product { " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                " }";
    }
}

