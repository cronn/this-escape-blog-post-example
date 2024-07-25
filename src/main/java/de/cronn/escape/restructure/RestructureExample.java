package de.cronn.escape.restructure;

import de.cronn.escape.usefinal.Musician;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class RestructureExample {

    public RestructureExample(MusicianInstrumentCache cache, FileBasedMusicianInstrumentImporter importer) {
        System.out.println();
        System.out.println("Restructure Code Example");
        Stream.of("Jimi", "Miles", "Ludwig", "Oskar").forEach(name -> {
            String instrument = cache.getInstrumentFor(name);
            new Musician(name, instrument);
        });
        System.out.println("Update Cache");
        importer.setMappingResource("classpath:other_mapping.csv");
        importer.importMapping();
        Stream.of("Jimi", "Miles", "Ludwig", "Oskar").forEach(name -> {
            String instrument = cache.getInstrumentFor(name);
            new Musician(name, instrument);
        });
        System.out.println();
    }
}
