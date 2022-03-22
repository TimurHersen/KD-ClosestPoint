/*
 * @author
 * Ludvig Warpe, luwa9626
 */

import java.util.Objects;

public class Point {

    private int xCoord;
    private int yCoord;

    public Point(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public double distanceTo(Point point) {
        double xDiff = Math.pow((point.xCoord - this.xCoord), 2);
        double yDiff = Math.pow((point.yCoord - this.yCoord), 2);
        return Math.sqrt(xDiff + yDiff);
    }

    public double getxCoord() {
        return xCoord;
    }

    public double getyCoord() {
        return yCoord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return getxCoord() == point.getxCoord() && getyCoord() == point.getyCoord();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getxCoord(), getyCoord());
    }

    @Override
    public String toString() {
        return "Point{" +
                "xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                '}';
    }
}
