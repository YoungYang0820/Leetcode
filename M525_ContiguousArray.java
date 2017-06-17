import java.util.HashMap;

/**
 * Created by yangjiawei on 2017/6/17.
 */
public class M525_ContiguousArray {
    public int findMaxLength(int[] nums) {
        for (int num : nums) {
            if (num == 0) num = -1;
        }
        HashMap<Integer, Integer> sumToIndex = new HashMap<>();
        int sum = 0;
        int max = 0;
        sumToIndex.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            }
            else {
                sumToIndex.put(sum, i);
            }
        }
        return max;
    }
}
