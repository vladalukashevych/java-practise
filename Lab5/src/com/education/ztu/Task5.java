package com.education.ztu;

import java.util.TreeSet;

public class Task5 {
    public static void DoTask() {
        TreeSet<Product> productSet = new TreeSet<>();

        productSet.add(new Product(1, "Product A", 19.99));
        productSet.add(new Product(2, "Product B", 29.99));
        productSet.add(new Product(3, "Product C", 39.99));

        System.out.println("First Product in the Set:");
        Product firstProduct = productSet.first();
        firstProduct.displayInfo();

        System.out.println("Last Product in the Set:");
        Product lastProduct = productSet.last();
        lastProduct.displayInfo();

        System.out.println("Products with price less than 30:");
        TreeSet<Product> headSet = new TreeSet<>(productSet.headSet(new Product(0, "", 30)));
        for (Product product : headSet) {
            product.displayInfo();
        }

        System.out.println("Products with price between 25 and 40:");
        TreeSet<Product> subSet = new TreeSet<>(productSet.subSet(new Product(0, "", 25), new Product(0, "", 40)));
        for (Product product : subSet) {
            product.displayInfo();
        }

        System.out.println("Products with price greater than or equal to 30:");
        TreeSet<Product> tailSet = new TreeSet<>(productSet.tailSet(new Product(0, "", 30)));
        for (Product product : tailSet) {
            product.displayInfo();
        }

        System.out.println("Product with price closest to 28 (ceiling):");
        Product ceilingProduct = productSet.ceiling(new Product(0, "", 28));
        if (ceilingProduct != null) {
            ceilingProduct.displayInfo();
        }

        System.out.println("Product with price closest to 28 (floor):");
        Product floorProduct = productSet.floor(new Product(0, "", 28));
        if (floorProduct != null) {
            floorProduct.displayInfo();
        }

        System.out.println("Removing First Product from the Set:");
        Product removedFirstProduct = productSet.pollFirst();
        if (removedFirstProduct != null) {
            removedFirstProduct.displayInfo();
        }

        System.out.println("Removing Last Product from the Set:");
        Product removedLastProduct = productSet.pollLast();
        if (removedLastProduct != null) {
            removedLastProduct.displayInfo();
        }

        System.out.println("Descending Set:");
        TreeSet<Product> descendingSet = new TreeSet<>(productSet.descendingSet());
        for (Product product : descendingSet) {
            product.displayInfo();
        }
    }
}
