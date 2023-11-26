package com.education.ztu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task4 {
    public static void DoTask() {
        List<Product> products = Arrays.asList(
                new Product("Product1", "Brand1", 800, 10),
                new Product("Product2", "Brand2", 1200, 5),
                new Product("Product3", "Brand1", 1500, 8),
                new Product("Product4", "Brand3", 900, 15)
        );

        List<String> brands = products.stream()
                .map(Product::getBrand)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Бренди: " + brands);

        List<Product> cheapProducts = products.stream()
                .filter(product -> product.getPrice() < 1000)
                .limit(2)
                .collect(Collectors.toList());

        System.out.println("Дешеві товари: " + cheapProducts);

        int totalItemCount = products.stream()
                .mapToInt(Product::getCount)
                .sum();

        System.out.println("Загальна кількість товарів на складі: " + totalItemCount);

        Map<String, List<Product>> productsByBrand = products.stream()
                .collect(Collectors.groupingBy(Product::getBrand));

        System.out.println("Товари за брендами: " + productsByBrand);

        Product[] sortedProducts = products.stream()
                .sorted(Comparator.comparingInt(Product::getPrice))
                .toArray(Product[]::new);

        System.out.println("Відсортовані товари за ціною: " + Arrays.toString(sortedProducts));
    }
}
