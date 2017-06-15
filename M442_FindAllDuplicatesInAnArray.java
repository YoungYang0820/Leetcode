import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangjiawei on 2017/6/15.
 */
public class M442_FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(index + 1));
            }
            nums[index] *= -1;
        }
        return result;
    }
}
