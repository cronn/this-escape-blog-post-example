package de.cronn.escape.usepostconstruct;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Component
public class FileBasedMusicianInstrumentCache extends MusicianInstrumentCache {

    private final ResourceLoader resourceLoader;
    private String mappingResource = "classpath:mapping.csv";

    public FileBasedMusicianInstrumentCache(ResourceLoader resourceLoader) {
        System.out.println("FileBasedMusicianInstrumentCache.init()");
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void updateCache() {
        System.out.println("FileBasedMusicianInstrumentCache.updateCache()");
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
