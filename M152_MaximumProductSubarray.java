
/**
 * Created by yangjiawei on 2017/4/9.

    Save maxProduct and minProduct, when meet a negative number
    maxProduct and minProduct will swap after multiplication.
    So the maxProduct will always store the max product before meeting a zero.
*/

public class M152_MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int preMaxProduct = nums[0];
        int preMinProduct = nums[0];
        int maxProduct = 0;
        int minProduct = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                maxProduct = Math.max(preMinProduct * nums[i], nums[i]);
                minProduct = Math.min(preMaxProduct * nums[i], nums[i]);
            }
            else {
                maxProduct = Math.max(preMaxProduct * nums[i], nums[i]);
                minProduct = Math.min(preMinProduct * nums[i], nums[i]);
            }
            preMaxProduct = maxProduct;
            preMinProduct = minProduct;
            if (maxProduct > max) max = maxProduct;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] a = {2, 3};
        System.out.println(maxProduct(a));
    }
}
