package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int count) {
        if (apartments.isEmpty()) {
            return new ArrayList<>();
        }
        return apartments.stream()
                .sorted(Home::compareTo)
                .limit(count)
                .map(Home::toString)
                .toList();
    }
}
// END
