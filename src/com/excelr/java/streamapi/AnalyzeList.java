package com.excelr.java.streamapi;

import java.util.ArrayList;
import java.util.List;
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

        List<Product> filtered = products.stream()
                .filter(price -> price.getPrice()>1000)
                .toList();

        filtered.forEach(System.out::println);
    }
}
