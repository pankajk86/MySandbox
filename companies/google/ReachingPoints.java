package google;

public class ReachingPoints {

    public static void main(String[] args) {

        int sx = 1, sy = 1, tx = 3, ty = 5;
        boolean result = reachingPoints(sx, sy, tx, ty);
        System.out.println(result);
    }

    private static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx <= tx && sy <= ty) {
            if (sx == tx && sy == ty) return true;

            if (tx > ty) tx %= ty;
            else ty %= tx;

            if (tx == sx) {
                return (ty - sy) % tx == 0;
            }

            if (ty == sy) {
                return (tx - sx) % ty == 0;
            }
        }
        return false;
    }
}
