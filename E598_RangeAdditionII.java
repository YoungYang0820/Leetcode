/**
 * Created by yangjiawei on 2017/6/27.
 */
public class E598_RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        int xMin = m;
        int yMin = n;
        for (int i = 0; i < ops.length; i++) {
            xMin = Math.min(xMin, ops[i][0]);
            yMin = Math.min(yMin, ops[i][1]);
        }
        return xMin * yMin;
    }
}
