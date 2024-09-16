package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class Validator {
    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                var resultField = field.getName();
                field.setAccessible(true);
                String value = (String) field.get(address);
                if (field.isAnnotationPresent(NotNull.class) && (value == null)) {
                    result.add(resultField);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
// END
