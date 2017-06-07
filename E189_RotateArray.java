/**
 * Created by yangjiawei on 2017/6/7.
 */
public class E189_RotateArray {
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] res = new int[k];
        for (int i = nums.length - k; i < nums.length; i++) {
            res[i - nums.length + k] = nums[i];
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = k - 1; i >= 0; i--) {
            nums[i] = res[i];
        }
    }
    public static void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }
    private static void reverseArray(int[] arr, int low, int high) {
        int times = (high - low + 1) / 2;
        for (int i = 0; i < times; i++) {
            int tmp = arr[low + i];
            arr[low + i] = arr[high - i];
            arr[high - i] = tmp;
        }
    }
}
