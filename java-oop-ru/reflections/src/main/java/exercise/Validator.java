package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class Validator {
    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            var resultField =field.getName();
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)) {
                result.add(resultField);
            }
        }
        return result;
    }
}
// END
