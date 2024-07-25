package de.cronn.escape.restructure;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Component
public final class FileBasedMusicianInstrumentImporter {

    @Qualifier("musicianInstrumentCacheRestructure")
    private final MusicianInstrumentCache cache;
    private final ResourceLoader resourceLoader;
    private String mappingResource = "classpath:mapping.csv";

    public FileBasedMusicianInstrumentImporter(MusicianInstrumentCache cache,
                                               ResourceLoader resourceLoader) {
        this.cache = cache;
        this.resourceLoader = resourceLoader;
        importMapping();
    }

    public void importMapping() {
        // Logic for importing mapping and adding it to the cache. Briefly,
        // represented by the following lines:
        Resource resource = resourceLoader.getResource(mappingResource);
        try {
            String content = resource.getContentAsString(StandardCharsets.UTF_8);
            Arrays.stream(content.split("\n"))
                    .map(line -> line.split(","))
                    .forEach(mapping -> cache.put(mapping[0], mapping[1]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getMappingResource() {
        return mappingResource;
    }

    public void setMappingResource(String mappingResource) {
        this.mappingResource = mappingResource;
    }
}
