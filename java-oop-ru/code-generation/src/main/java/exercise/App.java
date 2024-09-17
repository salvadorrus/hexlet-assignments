package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path filePath, Car car) throws IOException {
        var fileJson = Car.serialize(car);
        Files.writeString(filePath, fileJson, StandardOpenOption.WRITE);
    }

    public static Car extract(Path filePath) throws IOException {
        var fileJson = Files.readString(filePath);
        return Car.deserialize(fileJson);
    }
}
// END
