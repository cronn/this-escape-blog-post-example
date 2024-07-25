package de.cronn.escape.usepostconstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Component
public class OtherFileBasedMusicianInstrumentCache extends MusicianInstrumentCache {

    @Value("classpath:other_mapping_postconstruct.csv")
    private Resource resource;

    @Override
    public void updateCache() {
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
