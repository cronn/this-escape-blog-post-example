package de.cronn.escape;

import de.cronn.escape.restructure.MusicianInstrumentCache;
import de.cronn.escape.usepostconstruct.FileBasedMusicianInstrumentCache;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EscapeApplicationTests {

    @Autowired
    private MusicianInstrumentCache cacheRestructure;

    @Autowired
    private FileBasedMusicianInstrumentCache cachePostConstruct;

    @Test
    void contextLoads() {
    }

    @Test
    void restructure_example_should_import_cache() {
        Assertions.assertEquals("guitar", cacheRestructure.getInstrumentFor("Jimi"));
        Assertions.assertNull(cacheRestructure.getInstrumentFor("Miles"));
    }

    @Test
    void postConstruct_example_should_import_cache() {
        Assertions.assertEquals("guitar", cachePostConstruct.getInstrumentFor("Jimi"));
        Assertions.assertNull(cacheRestructure.getInstrumentFor("Miles"));
    }
}
