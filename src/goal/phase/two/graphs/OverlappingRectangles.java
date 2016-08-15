package goal.phase.two.graphs;

public class OverlappingRectangles {

    public static void main(String[] args) {
        Point l1 = new Point(10, 30);
        Point r1 = new Point(30, 10);
        Point l2 = new Point(20, 40);
        Point r2 = new Point(40, 20);

        boolean result = areOverlapping(l1, r1, l2, r2);
        System.out.println("Are rectangles overlapping?: " + result);
    }

    private static boolean areOverlapping(Point l1, Point r1, Point l2, Point r2) {

        if (l1.x > r2.x || l2.x > r1.x) {
            return false;
        }

        if (l1.y < r2.y || l2.y < r1.y) {
            return false;
        }

        return true;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
