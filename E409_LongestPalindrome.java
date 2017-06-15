import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yangjiawei on 2017/6/15.
 */
public class E409_LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> set : map.entrySet()) {
            if (result % 2 == 0 && set.getValue() % 2 == 1)
                result += set.getValue();
            else if (set.getValue() % 2 == 0)
                result += set.getValue();
            else
                result += set.getValue() - 1;
        }
        return result;
    }
}
