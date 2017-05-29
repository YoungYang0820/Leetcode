/**
 * Created by yangjiawei on 2017/5/28.
 */
public class H164_MaximumGap {
    public static int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        if (n == 2) return Math.abs(nums[0] - nums[1]);
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
                continue;
            }
            if (num > max) max = num;
        }
        if (max == min) return 0;

        int bucketSize = (max - min) / (n - 1);
        if (bucketSize == 0) bucketSize++;
        int bucketLen = (max - min) / bucketSize;
        int[] bucketMin = new int[bucketLen];
        int[] bucketMax = new int[bucketLen];
        for (int i = 0; i < n; i++) {
            int index = (nums[i] - min) / bucketSize;
            if (index == bucketLen) index--;
            if (nums[i] < bucketMin[index] || bucketMin[index] == 0) bucketMin[index] = nums[i];
            if (nums[i] > bucketMax[index]) bucketMax[index] = nums[i];
        }

        int maxGap = 0;
        for (int i = 0; i < bucketLen; i++) {
            if (bucketMin[i] - min > maxGap) maxGap = bucketMin[i] - min;
            if (bucketMax[i] != 0) min = bucketMax[i];
        }

        return maxGap;
    }
}
