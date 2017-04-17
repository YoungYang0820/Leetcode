import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangjiawei on 2017/4/17.
 */
public class E119_PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0, 1);
        for (int i = 1; i <= rowIndex; i++) {
            result.add(i, 1);
            int temp1 = result.get(0);
            for (int j = 1; j < i; j++) {
                int temp2 = result.get(j);
                result.set(j, temp1 + temp2);
                temp1 = temp2;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
