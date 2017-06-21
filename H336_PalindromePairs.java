import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangjiawei on 2017/6/18.
 */
public class H336_PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                if (isPalindrome(words[i] + words[j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
                if (isPalindrome(words[j] + words[i])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(j);
                    list.add(i);
                    result.add(list);
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        int mid = s.length() / 2;
        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
