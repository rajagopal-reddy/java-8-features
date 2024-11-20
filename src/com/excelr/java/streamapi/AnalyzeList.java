package com.excelr.java.streamapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product{
    int id;
    String name;
    double price;
    String category;

    public Product(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}

public class AnalyzeList {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"book",3090,"stationary"));
        products.add(new Product(2,"pen",20,"stationary"));
        products.add(new Product(3,"shampoo",2000,"bathroom"));
        products.add(new Product(4,"brush",60,"bathroom"));
        products.add(new Product(5,"soap",5000,"bathroom"));
        products.add(new Product(6,"biscuit",140,"snacks"));
        products.add(new Product(7,"chips",530,"snacks"));
        products.add(new Product(8,"knife",1250,"kitchen"));
        products.add(new Product(9,"pan",1650,"kitchen"));


        System.out.println("Products priced above 1000: ");
        List<Product> filtered = products.stream()
                .filter(price -> price.getPrice()>1000)
                .toList();

        filtered.forEach(System.out::println);

        System.out.println("------------------------");

        System.out.println("Group products by their category: ");
        Map<String,List<Product>> group = products.stream()
                        .collect(Collectors.groupingBy(Product::getCategory));

        group.forEach((category,items) -> {
            System.out.println(category + " : " + items);
        });

        System.out.println("------------------------");

        System.out.println("Total cost of all products: ");
        double total = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println(total);

        System.out.println("------------------------");

        System.out.println("Top 3 expensive products: ");
        List<String> top3 = products.stream()
                .sorted(Comparator
                        .comparingDouble(Product::getPrice)
                        .reversed())
                .limit(3)
                .map(Product::getName)
                .toList();

        top3.forEach(System.out::println);
    }
}