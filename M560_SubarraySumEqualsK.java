import java.util.HashMap;

/**
 * Created by yangjiawei on 2017/6/3.
 */
public class M560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int result = 0;
        for (int num : nums) {
            sum += num;
            int count = map.getOrDefault(sum, 0);
            int diff = sum - k;
            if (map.containsKey(diff))
                result += map.get(diff);
            map.put(sum, ++count);
        }
        return result;
    }
}
