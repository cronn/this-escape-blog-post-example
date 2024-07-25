package de.cronn.escape.usefinal;

import java.util.Objects;

public final class Musician extends Person { // Class is now final

    private final String instrument;

    public Musician(String name, String instrument) {
        super(name);
        this.instrument = Objects.requireNonNullElse(instrument, "triangle");
        printInstrument();
    }

    public void printInstrument() {
        System.out.println("I heard you play " + instrument + ". Awesome!");
    }
}

// variant wich produce a this-escape warning below

//public class Musician extends Person {
//
//    private final String instrument;
//
//    public Musician(String name, String instrument) {
//        super(name);
//        this.instrument = Objects.requireNonNullElse(instrument, "triangle");
//    }
//
//    @Override
//    public void greet() {
//        super.greet();
//        System.out.println("I heard you play " + instrument + ". Awesome!");
//    }
//}

