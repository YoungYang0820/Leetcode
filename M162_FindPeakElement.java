/**
 * Created by yangjiawei on 2017/4/9.
 *
 * find() is the initial version
 * find2() is a new quicker version based on discussion tips
 */
public class M162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        return find(0, nums.length-1, nums);
    }


    private int find(int start, int end, int[] nums) {
        int middle = (start + end)/2;
        if (middle == 0) {
            if (nums[middle] > nums[middle+1]) return middle;
            else return find(middle+1, end, nums);
        }
        else if (middle == nums.length-1) {
            if (nums[middle] > nums[middle-1]) return middle;
            else return find(start, middle-1, nums);
        }
        else {
            if (nums[middle] > nums[middle-1] && nums[middle] > nums[middle+1]) return middle;
            if (nums[middle] < nums[middle-1]) return find(start, middle-1, nums);
            if (nums[middle] < nums[middle+1]) return find(middle+1, end, nums);
        }
        return 0;
    }

    private int find2(int start, int end, int[] nums) {
        if (start == end) return start;
        else {
            int middle1 = (start + end)/2;
            int middle2 = middle1 + 1;
            if (nums[middle1] > nums[middle2]) return find2(start, middle1, nums);
            else return find2(middle2, end, nums);
        }
    }
}
