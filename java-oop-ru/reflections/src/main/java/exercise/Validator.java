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
            field.setAccessible(true);
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (notNull == null) {
                result.add(String.valueOf(field));
            }
        }
        return result;
    }
}
// END
