import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangjiawei on 2017/4/13.
 */
public class E118PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> element;
        for (int i = 0; i < numRows; i++) {
            element = new ArrayList<>();
            element.add(0, 1);
            for (int j = 1; j < i; j++) {
                element.add(j, result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            if(i != 0) element.add(i, 1);
            result.add(i, element);
        }
        return (List) result;
    }
    public static void main(String[] args) {
        System.out.print(generate(5));
    }
}
