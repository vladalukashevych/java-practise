package com.education.ztu;

import java.util.*;

public class Task3 {
    public static void DoTask() {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product(1, "Product A", 19.99));
        productList.add(new Product(2, "Product B", 29.99));
        productList.add(new Product(3, "Product C", 39.99));

        System.out.println("Size of the product list: " + productList.size());

        System.out.println("Product List:");
        for (Product product : productList) {
            product.displayInfo();
            System.out.println("--------------------");
        }

        Product firstProduct = productList.get(0);
        System.out.println("First Product:");
        firstProduct.displayInfo();
        System.out.println("--------------------");

        System.out.println("Product List (Using Iterator):");
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            product.displayInfo();
            System.out.println("--------------------");
        }

        System.out.println("Product List (Using ListIterator):");
        ListIterator<Product> listIterator = productList.listIterator(productList.size());
        while (listIterator.hasPrevious()) {
            Product product = listIterator.previous();
            product.displayInfo();
            System.out.println("--------------------");
        }

        productList.remove(1);
        System.out.println("Product List after removing an item:");
        for (Product product : productList) {
            product.displayInfo();
            System.out.println("--------------------");
        }

        Collections.sort(productList, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("Product List after sorting by price:");
        for (Product product : productList) {
            product.displayInfo();
            System.out.println("--------------------");
        }

        Product productToCheck = new Product(2, "Product B", 29.99);
        System.out.println("Does the list contain Product B?");
        System.out.println(productList.contains(productToCheck));

        Product[] productArray = productList.toArray(new Product[0]);
        System.out.println("Product Array:");
        for (Product product : productArray) {
            product.displayInfo();
            System.out.println("--------------------");
        }

        productList.clear();
        System.out.println("Product List after clearing:");
        System.out.println("Size of the product list: " + productList.size());
    }
}
