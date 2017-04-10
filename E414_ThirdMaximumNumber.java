import java.util.HashSet;

/**
 * Created by yangjiawei on 2017/4/10.
 */
public class E414_ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        HashSet<Integer> nonEqual = new HashSet<>();
        int[] result = new int[3];
        result[0] = nums[0];
        result[1] = Integer.MIN_VALUE;
        result[2] = Integer.MIN_VALUE;
        nonEqual.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            nonEqual.add(nums[i]);
            if (nums[i] > result[0]) {
                result[2] = result[1];
                result[1] = result[0];
                result[0] = nums[i];
            }
            else if (nums[i] > result[1]) {
                if (nums[i] != result[0]) {
                    result[2] = result[1];
                    result[1] = nums[i];
                }
            }
            else if (nums[i] > result[2]) {
                if (nums[i] != result[1])
                    result[2] = nums[i];
            }
        }
        return nonEqual.size() >= 3 ? result[2]:result[0];
    }
    public static void main(String[] args) {
        int[] a = {1,2,1};
        System.out.println(thirdMax(a));
    }
}
