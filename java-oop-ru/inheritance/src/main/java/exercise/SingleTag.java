package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String nameTag, Map<String, String> attributesTeg) {
        super(nameTag, attributesTeg);
    }

    @Override
    public String toString() {
        return getToString();
    }
}
// END
