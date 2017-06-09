import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangjiawei on 2017/6/9.
 */
public class M565_ArrayNesting {
    public static int arrayNesting(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            while (!set2.contains(tmp)) {
                set.add(tmp);
                set2.add(tmp);
                tmp = nums[tmp];
            }
            if (set.size() > longest) {
                longest = set.size();
            }
            set = new HashSet<>();
        }
        return longest;
    }

}
