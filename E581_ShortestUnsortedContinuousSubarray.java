/**
 * Created by yangjiawei on 2017/6/6.
 */
public class E581_ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int low = nums.length - 1;
        int high = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) high = i;
            max = Math.max(max, nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > min) low = i;
            min = Math.min(min, nums[i]);
        }
        return (high > low && nums[high] != nums[low]) ? high - low + 1 : 0;
    }
}
