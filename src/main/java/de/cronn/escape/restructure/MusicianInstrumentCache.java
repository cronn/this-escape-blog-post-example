package de.cronn.escape.restructure;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component("musicianInstrumentCacheRestructure")
public class MusicianInstrumentCache {

    private final Map<String, String> cache = new ConcurrentHashMap<>();

    void put(String name, String instrument) {
        cache.put(name, instrument);
    }

    public String getInstrumentFor(String name) {
        return cache.get(name);
    }
}
