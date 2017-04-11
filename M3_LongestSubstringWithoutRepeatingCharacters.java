import java.util.Arrays;

/**
 * Created by yangjiawei on 2017/4/11.
 */
public class M3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        Arrays.fill(index, -1);
        int max = 0;
        int from = 0;
        for (int i = 0; i < s.length(); i++) {
            if (index[s.charAt(i)] >= from) {
                from = index[s.charAt(i)] + 1;
            }
            index[s.charAt(i)] = i;
            max = Math.max(max, i - from + 1);
        }
        return max;
    }
}
