package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {

    private String bodyTag;
    private List<Tag> childrenTag;

    public PairedTag(String nameTag, Map<String, String> attributesTeg, String bodyTag, List<Tag> childrenTag) {
        super(nameTag, attributesTeg);
        this.bodyTag = bodyTag;
        this.childrenTag = childrenTag;
    }

    @Override
    public String toString() {
        String resultList = childrenTag.stream().map(Tag::getToString)
                .collect(Collectors.joining(""));
        return getToString() + bodyTag + resultList
                + "</" + getNameTag() + ">";
    }
}
// END
