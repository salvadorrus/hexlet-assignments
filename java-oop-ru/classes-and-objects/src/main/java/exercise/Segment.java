package exercise;

// BEGIN
public class Segment {
    private final Point point1;
    private final Point point2;
    private Point midPoint;

    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Segment getBeginPoint() {
        return new Segment(point1, point2);
    }

    public Segment getEndPoint() {
        return new Segment(point1, point2);
    }

    public Point getMidPoint() {
        return midPoint;
    }
}
// END
