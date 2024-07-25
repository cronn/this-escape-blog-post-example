package de.cronn.escape.restructure;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Component
public final class OtherFileBasedMusicianInstrumentImporter {

    @Qualifier("musicianInstrumentCacheRestructure")
    private final MusicianInstrumentCache cache;
    @Value("classpath:other_mapping_restructure.csv")
    private Resource resource;

    public OtherFileBasedMusicianInstrumentImporter(MusicianInstrumentCache cache) {
        this.cache = cache;
    }

    @PostConstruct
    public void importMapping() {
        // Logic for importing mapping and adding it to the cache. Briefly,
        // represented by the following lines:
        try {
            String content = resource.getContentAsString(StandardCharsets.UTF_8);
            Arrays.stream(content.split("\n"))
                    .map(line -> line.split(","))
                    .forEach(mapping -> cache.put(mapping[0], mapping[1]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
