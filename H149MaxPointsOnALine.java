import java.util.HashMap;

/**
 * Created by yangjiawei on 2017/4/13.
 */
public class H149MaxPointsOnALine {
     private static class Point {
         int x;
         int y;

         Point() {
             x = 0;
             y = 0;
         }

         Point(int a, int b) {
             x = a;
             y = b;
         }
     }
    public static int maxPoints(Point[] points) {
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            int repeatOrigin = 0;
            int tempMax = 0;
            HashMap<Double, Integer> slopes = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (equal(points[i], points[j]))
                    repeatOrigin++;
                else {
                    double slope = slopeTo(points[i], points[j]);
                    int temp = slopes.getOrDefault(slope, 0) + 1;
                    slopes.put(slope, temp);
                    tempMax = Math.max(tempMax, temp);
                }
            }
            max = Math.max(tempMax + repeatOrigin, max);
        }
        return max;
    }

    private static double slopeTo(Point a, Point b) {
         if (a.x == b.x) return Double.MAX_VALUE;
         return (double)(b.y - a.y)/(b.x - a.x);
    }

    private static boolean equal(Point a, Point b) {
         if (a.x == b.x && a.y == b.y) return true;
         return false;
    }

    public static void main(String[] args) {
         Point a = new Point(0, 0);
         Point d = new Point(0, 0);
         Point e = new Point(0, 0);
         Point b = new Point(4, 5);
         Point c = new Point(4, 5);
         Point[] point = {a, b, c, d, e};
         System.out.println(maxPoints(point));
    }
}
