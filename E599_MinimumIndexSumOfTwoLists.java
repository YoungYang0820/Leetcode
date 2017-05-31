import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yangjiawei on 2017/5/31.
 */
public class E599_MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (map.get(list2[i]) + i < min) {
                    min = map.get(list2[i]) + i;
                    result = new ArrayList<>();
                    result.add(list2[i]);
                }
                else if (map.get(list2[i]) + i == min)
                    result.add(list2[i]);
            }
        }
        String[] res = new String[result.size()];
        for (int i = 0; i < result.size(); i++)
            res[i] = result.get(i);
        return res;
    }
}
