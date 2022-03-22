/*
 * @author
 * Ludvig Warpe, luwa9626
 */

import java.util.*;

public class ClosestPoints {

    public static Point[] findClosestPairOfPoints(Point[] points) {
        Arrays.sort(points, new PointXComparator());
        int n = points.length;
        return findClosestPoints(points, n);
    }

    private static Point[] findClosestPoints(Point[] points, int n) {

        if (n <= 4)
            return findMinDistance(points);

        int mid = n / 2;
        Point midPoint = points[mid];

        Point[] minLeft = findClosestPoints(Arrays.copyOfRange(points, 0, mid), mid);
        Point[] minRight = findClosestPoints(Arrays.copyOfRange(points, mid, n), mid);
        Point[] minPair = min(minLeft, minRight);

        double minDistance = minPair[0].distanceTo(minPair[1]);

        ArrayList<Point> strip = new ArrayList<>();
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(points[i].getxCoord() - midPoint.getxCoord()) < minDistance) {
                strip.add(points[i]);
                m++;
            }
        }

        if (strip.size() <= 1)
            return minPair;
        else
            return min(minPair, stripMinDistance(strip, m, minDistance));
    }


    private static Point[] stripMinDistance(ArrayList<Point> strip, int n, double d) {
        double min = d;
        Point[] minDistPoints = new Point[2];
        minDistPoints[0] = strip.get(0);
        minDistPoints[1] = strip.get(1);

        Collections.sort(strip, new PointYComparator());
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n && (strip.get(j).getyCoord() - strip.get(i).getyCoord()) < min; j++) {
                double dist = strip.get(i).distanceTo(strip.get(j));
                if (dist < min) {
                    min = dist;
                    minDistPoints[0] = strip.get(i);
                    minDistPoints[1] = strip.get(j);
                }
            }
        return minDistPoints;
    }

    private static Point[] findMinDistance(Point[] points) {
        Point[] minPoints = new Point[2];
        double min = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++)
            for (int j = i + 1; j < points.length; j++) {
                double dist = points[i].distanceTo(points[j]);
                if (dist < min) {
                    min = dist;
                    minPoints[0] = points[i];
                    minPoints[1] = points[j];
                }
            }
        return minPoints;
    }

    private static Point[] min(Point[] minLeft, Point[] minRight) {
        return minLeft[0].distanceTo(minLeft[1]) < minRight[0].distanceTo(minRight[1]) ? minLeft : minRight;
    }
}

class PointXComparator implements Comparator<Point> {

    @Override
    public int compare(Point firstPoint, Point secondPoint) {
        return Double.compare(firstPoint.getxCoord(), secondPoint.getxCoord());
    }
}

class PointYComparator implements Comparator<Point> {

    @Override
    public int compare(Point firstPoint, Point secondPoint) {
        return Double.compare(firstPoint.getyCoord(), secondPoint.getyCoord());
    }
}


