package de.cronn.escape.usepostconstruct;

import de.cronn.escape.usefinal.Musician;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class UsePostConstructExample {

    public UsePostConstructExample(FileBasedMusicianInstrumentCache cache) {
        System.out.println();
        System.out.println("Post Construct Example");
        Stream.of("Jimi", "Miles", "Ludwig", "Oskar").forEach(name -> {
            String instrument = cache.getInstrumentFor(name);
            new Musician(name, instrument);
        });
        System.out.println("Update Cache");
        cache.setMappingResource("classpath:other_mapping.csv");
        cache.updateCache();
        Stream.of("Jimi", "Miles", "Ludwig", "Oskar").forEach(name -> {
            String instrument = cache.getInstrumentFor(name);
            new Musician(name, instrument);
        });
        System.out.println();
    }
}