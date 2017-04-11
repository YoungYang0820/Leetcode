import java.util.HashMap;

/**
 * Created by yangjiawei on 2017/4/11.
 *
 * Solved absolutely.
 */
public class E1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }
            map.put(target-nums[i], i);
        }
        return result;
    }
}
