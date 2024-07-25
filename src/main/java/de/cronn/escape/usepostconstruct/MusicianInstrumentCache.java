package de.cronn.escape.usepostconstruct;

import jakarta.annotation.PostConstruct;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class MusicianInstrumentCache {

    protected static final Map<String, String> cache =
            new ConcurrentHashMap<>();

    public MusicianInstrumentCache() {
        System.out.println("MusicianInstrumentCache.init()");
        // Remove importMapping() method call here
    }

    @PostConstruct // Add annotation
    public abstract void updateCache();

    public String getInstrumentFor(String name) {
        return cache.get(name);
    }
}

// variant wich produce a this-escape warning below

//public abstract class MusicianInstrumentCache {
//
//    protected static final Map<String, String> cache =
//            new ConcurrentHashMap<>();
//
//    public MusicianInstrumentCache() {
//        System.out.println("MusicianInstrumentCache.init()");
//        updateCache(); // Calls overrideable method, causes this-escape warning
//    }
//
//    public abstract void updateCache(); // Should be public and abstract
//
//    public String getInstrumentFor(String name) {
//        return cache.get(name);
//    }
//}
