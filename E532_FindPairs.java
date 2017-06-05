import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yangjiawei on 2017/6/5.
 */
public class E532_FindPairs {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) result++;
            }
            else {
                if (map.containsKey(entry.getKey() + k)) result++;
            }
        }
        return result;
    }
    public int findPairs2(int[] nums, int k) {
        int result = 0;
        if (k < 0) return 0;
        if (k == 0) {
            HashMap<Integer, Boolean> map = new HashMap<>();
            for (int num : nums) {
                if (map.getOrDefault(num, false)) {
                    result++;
                    map.put(num, false);
                }
                map.putIfAbsent(num, true);
            }
        }
        else {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num)) continue;
                if (set.contains(num - k)) result++;
                if (set.contains(num + k)) result++;
                set.add(num);
            }
        }
        return result;
    }
}
