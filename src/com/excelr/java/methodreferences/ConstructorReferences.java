package com.excelr.java.methodreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
public class ConstructorReferences {

    public static void main(String[] args) {
        List<String> names = List.of("Tarun", "Gopal", "Haru", "Jimmy", "Lina", "Lisa");
        List<Integer> ages = List.of(23, 33, 13, 43, 25, 27);

        List<User> users = new ArrayList<>();
        BiFunction<String, Integer, User> userConstructor = User::new;

        for (int i = 0; i < names.size(); i++) {
            users.add(userConstructor.apply(names.get(i), ages.get(i) ));
        }
        users.forEach(System.out::println);
    }
}