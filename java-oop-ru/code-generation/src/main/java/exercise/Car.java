package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public static String serialize(Car car) throws JsonProcessingException {
        var mapper = new ObjectMapper();
        return mapper.writeValueAsString(car);
    }

    public static Car deserialize(String stringJson) throws IOException {
        var mapper = new ObjectMapper();
        return mapper.readValue(stringJson, Car.class);
    }
    // END
}
