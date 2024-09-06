package exercise;

// BEGIN
public class LabelTag implements TagInterface {

    private String inputText;
    private String otherTeg;

    public LabelTag(String inputText, TagInterface otherTeg) {
        this.inputText = inputText;
        this.otherTeg = otherTeg.render();
    }

    @Override
    public String render() {
        return "<label>" + inputText + otherTeg + "<label>";
    }
}
// END
