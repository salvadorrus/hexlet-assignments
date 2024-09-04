package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {

    private final String filePath;
    private final Map<String, String> fileStorage;

    public FileKV(String filePath, Map<String, String> fileStorage) {
        this.filePath = filePath;
        this.fileStorage = readFile(filePath, fileStorage);
    }

    public static Map<String, String> readFile (String filePath, Map<String, String> fileStorage) {

        Map<String, String> resultStorage = new HashMap<>(fileStorage);
        var normalisePath = Utils.readFile(filePath);
        var data = Utils.deserialize(normalisePath);
        resultStorage.putAll(data);

        var normaliseStorage = Utils.serialize(fileStorage);
        Utils.writeFile(filePath, normaliseStorage);
        return resultStorage;
    }

    @Override
    public void set(String key, String value) {
        fileStorage.put(key, value);
        var data = Utils.serialize(fileStorage);
        Utils.writeFile(filePath, data);
    }

    @Override
    public void unset(String key) {
        fileStorage.remove(key);
        var data = Utils.serialize(fileStorage);
        Utils.writeFile(filePath, data);
    }

    @Override
    public String get(String key, String defaultValue) {
        return fileStorage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        var data = Utils.readFile(filePath);
        return Utils.deserialize(data);
    }
}
// END
