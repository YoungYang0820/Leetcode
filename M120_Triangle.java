import java.util.List;

/**
 * Created by yangjiawei on 2017/6/8.
 */
public class M120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int depth = triangle.size();
        for (int i = depth - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                row.set(j, row.get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
