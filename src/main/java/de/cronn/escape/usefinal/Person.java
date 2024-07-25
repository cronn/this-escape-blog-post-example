package de.cronn.escape.usefinal;

import java.util.Objects;

public class Person {

    private final String name;

    public Person(String name) {
        this.name = Objects.requireNonNullElse(name, "stranger");
        greet();
    }

    public final void greet() { // Method is now final
        System.out.println("Hello " + name + "!");
    }
}

// variant wich produce a this-escape warning below

//public class Person {
//
//    private final String name;
//
//    public Person(String name) {
//        this.name = Objects.requireNonNullElse(name, "stranger");
//        greet(); // Calls overrideable method, causes this-escape warning
//    }
//
//    public void greet() {
//        System.out.println("Hello " + name + "!");
//    }
//}
