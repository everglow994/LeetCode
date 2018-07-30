package Coding;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKNearestPoints {
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }


    class PointComparator implements Comparator<Point> {
        Point origin;
        PointComparator(Point origin) {
            this.origin = origin;
        }
        @Override
        public int compare(Point o1, Point o2) {
            return getDistance(o2, origin) - getDistance(o1, origin);
        }
    }

    public Point[] Solution(Point[] array, Point origin, int k) {
        if(array == null || array.length == 0)
            return null;

        PointComparator pointComparator = new PointComparator(origin);

        Queue<Point> maxHeap = new PriorityQueue<>(k, (Point a, Point b) -> getDistance(b, origin) - getDistance(a, origin));

        for(Point p: array) {
            maxHeap.offer(p);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        Point[] result = new Point[k];
        int i = 0;
        for(Point p: maxHeap) {
            result[i++] = p;
        }
        return result;
    }

    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}
