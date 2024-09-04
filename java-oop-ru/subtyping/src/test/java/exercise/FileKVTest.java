package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    void test() {
        Map<String, String> testMap = Map.of("key", "value");
        KeyValueStorage storage = new FileKV(filepath.toString(), testMap);
        var expected = Map.of("key", "value");

        assertEquals(storage.toMap(), expected);
        assertEquals(storage.get("key", "hexlet"), "value");
        assertEquals(storage.get("key1", "hexlet"), "hexlet");
    }

    @Test
    void fillStorage() {
        Map<String, String> testMap = Map.of("key", "value");
        KeyValueStorage storage = new FileKV(filepath.toString(), testMap);
        var newKey = "key1";
        var newValue = "value1";
        var fillStorage = Map.of("key", "value", newKey, newValue);

        storage.set(newKey, newValue);
        assertEquals(storage.get("key", "hexlet"), "value");
        assertEquals(storage.get(newKey, "hexlet"), "value1");
        assertEquals(storage.get("testDefaultValue", "hexlet"), "hexlet");
        assertEquals(storage.toMap(), fillStorage);

        storage.unset(newKey);
        assertEquals(storage.get("key", "hexlet"), "value");
        assertEquals(storage.get(newKey, "hexlet"), "hexlet");
        assertEquals(storage.toMap(), testMap);
    }
    // END
}
