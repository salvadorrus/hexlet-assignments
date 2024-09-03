package exercise;

// BEGIN
public class Cottage implements Home {
    private final double area;
    private final int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    public int getFloorCount() {
        return floorCount;
    }

    @Override
    public String toString() {
        return getFloorCount() + " этажный коттедж площадью "
                + getArea() + " метров";
    }

    public int compareTo(Home another) {
        if (getArea() == another.getArea()) {
            return 0;
        }
        return getArea() > another.getArea() ? 1 : -1;
    }
}
// END
