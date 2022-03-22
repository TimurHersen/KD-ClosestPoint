public class Main {

    public static void main(String[] args) {
        Point[] points = {new Point(25, 90), new Point(45, 80),
                new Point(70, 60), new Point(95, 10),
                new Point(0, 0), new Point(100, 100), new Point(10, 78),
                new Point(95, 12), new Point(20, 85)};

        Point[] closest = ClosestPoints.findClosestPairOfPoints(points);


        System.out.println("Closest Points:");
        for (Point p : closest)
            System.out.print(p + " ");
    }
}
