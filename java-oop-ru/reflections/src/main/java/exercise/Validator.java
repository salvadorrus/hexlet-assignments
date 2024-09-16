package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Object object) {
        List<String> result = new ArrayList<>();
        Address address = new Address();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (notNull == null) {
                result.add(String.valueOf(field));
            }
        }
        return result;
    }
}
// END
