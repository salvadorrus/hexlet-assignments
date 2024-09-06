package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private String nameTag;
    private Map<String, String> attributesTeg;

    public Tag(String nameTag, Map<String, String> attributesTeg) {
        this.nameTag = nameTag;
        this.attributesTeg = attributesTeg;
    }

    public String getNameTag() {
        return nameTag;
    }

    public Map<String, String> getAttributesTeg() {
        return attributesTeg;
    }

    public String getToString() {
        String result = attributesTeg.keySet().stream()
                .map(key -> key + "=" + "\"" + attributesTeg.get(key) + "\"")
                .collect(Collectors.joining(" ")).toString();
        if (attributesTeg.isEmpty()) {
            return "<" + nameTag + ">";
        }
        return "<" + nameTag + " " + result + ">";
    }
}
// END
