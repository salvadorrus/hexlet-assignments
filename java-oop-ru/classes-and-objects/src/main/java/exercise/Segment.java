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

    public Point getBeginPoint() {
        return this.point1;
    }

    public Point getEndPoint() {
        return this.point2;
    }

    public Point getMidPoint() {
        var midPointX = (point1.getX() + point2.getX()) / 2;
        var midPointY = (point1.getY() + point2.getY()) / 2;
        return new Point(midPointX, midPointY);
    }
}
// END
