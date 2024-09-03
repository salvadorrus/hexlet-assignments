package exercise;

// BEGIN
import java.util.*;
public class Flat implements Home {
    private final double area;
    private final double balconyArea;
    private final int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    public double getBalconyArea() {
        return balconyArea;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return  "Квартира площадью " + getArea()
                + " метров на " + getFloor() + " этаже";
    }

    public int compareTo(Home another) {
        if (getArea() == another.getArea()) {
            return 0;
        }
        return getArea() > another.getArea() ? 1 : -1;
    }
}
// END
