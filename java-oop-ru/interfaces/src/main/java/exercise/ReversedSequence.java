package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private final CharSequence str;

    public ReversedSequence(String str) {
        this.str = new StringBuilder(str).reverse().toString();
    }

    @Override
    public char charAt(int idx) {
        return str.charAt(idx);
    }

    @Override
    public int length() {
        return str.length();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return str.subSequence(start, end);
    }

    @Override
    public String toString() {
        return str.toString();
    }
}
// END
