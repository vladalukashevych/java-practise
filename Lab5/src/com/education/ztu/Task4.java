package com.education.ztu;

import java.util.ArrayDeque;

public class Task4 {
    public static void DoTask() {
        ArrayDeque<Product> productQueue = new ArrayDeque<>();

        productQueue.offerLast(new Product(1, "Product A", 19.99));
        productQueue.offerLast(new Product(2, "Product B", 29.99));
        productQueue.offerLast(new Product(3, "Product C", 39.99));

        System.out.println("First Product in the Queue:");
        Product firstProduct = productQueue.getFirst();
        firstProduct.displayInfo();

        System.out.println("Last Product in the Queue:");
        Product lastProduct = productQueue.peekLast();
        lastProduct.displayInfo();

        System.out.println("Removing Last Product from the Queue:");
        Product removedProduct = productQueue.pollLast();
        if (removedProduct != null) {
            removedProduct.displayInfo();
        }

        System.out.println("New Last Product in the Queue:");
        Product newLastProduct = productQueue.peekLast();
        if (newLastProduct != null) {
            newLastProduct.displayInfo();
        }

        System.out.println("Adding a New Product to the Front of the Queue:");
        Product newProduct = new Product(4, "New Product", 19.99);
        productQueue.push(newProduct);

        System.out.println("New First Product in the Queue:");
        Product newFirstProduct = productQueue.getFirst();
        newFirstProduct.displayInfo();
    }
}
