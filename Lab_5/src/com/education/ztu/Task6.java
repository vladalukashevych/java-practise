package com.education.ztu;

import java.util.*;

public class Task6 {
    public static void DoTask() {
        Map<String, Product> productMap = new HashMap<>();

        Product productA =  new Product(1, "Product A", 19.99);
        productMap.put("Product A", productA);
        productMap.put("Product B", new Product(2, "Product B", 29.99));
        productMap.put("Product C", new Product(3, "Product C", 39.99));

        System.out.println("  Product with the name \"Product B\": ");
        Product productB = productMap.get("Product B");
        productB.displayInfo();

        System.out.println("  Map contains key \"Product C\": ");
        System.out.println(productMap.containsKey("Product C"));

        System.out.println("  Map contains value \"Product(1, \"Product A\", 19.99)\": ");
        System.out.println(productMap.containsValue(productA));

        System.out.println("  Put if absent \"Product B\" - Product(2, \"Blah Blah\", 40.35): ");
        productMap.putIfAbsent("Product B", new Product(2, "Blah Blah", 40.35));
        Product productB1 = productMap.get("Product B");
        productB1.displayInfo();

        System.out.println("  Key set: ");
        productMap.put("Product C", new Product(3, "Product C", 39.99));
        Set<String> keySet = productMap.keySet();
        for (String key : keySet) {
            System.out.println(key);
        }

        System.out.println("  Values: ");
        Collection<Product> values = productMap.values();
        for (Product product : values) {
            product.displayInfo();
        }

        System.out.println("  Put all from existing Map to new Map: ");
        Map<String, Product> productMapNew = new HashMap<>();
        productMapNew.putAll(productMap);
        for (Map.Entry<String, Product> entry : productMapNew.entrySet()) {
            System.out.print("Key: " + entry.getKey() + ", Value: ");
            entry.getValue().displayInfo();
        }

        System.out.println("  Remove product with key \"Product C\": ");
        productMap.remove("Product C");
        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            System.out.print("Key: " + entry.getKey() + ", Value: ");
            entry.getValue().displayInfo();
        }

        System.out.println("  Entry set value \"Product(0, \"0\", 0)\" for all: ");
        Product productZero = new Product(0, "0", 0);
        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            entry.setValue(productZero);
            System.out.print("Key: " + entry.getKey() + ", Value: ");
            entry.getValue().displayInfo();
        }

        System.out.println("  Map size after clear: ");
        productMap.clear();
        System.out.println(productMap.size());
    }
}
