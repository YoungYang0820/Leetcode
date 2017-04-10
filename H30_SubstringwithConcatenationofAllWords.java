import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yangjiawei on 2017/4/10.
 *
 * Sweep the string s from left to right for (words.length) times(start pointer:[0,1,2...words.length])
 * Use two Hashmaps, one(times) saves times that every word appears in (words), another(countTimes) saves that every word
 * appears in the sweep queue. If the appearance of a word in (countTimes) > (times), remove the window until the values of
 * that word in (countTimes) and (times) are equal. Once the variable (count) == words.length, we get a successful hit.
 *
 * Once we meet a word that is not in (words), clear the Hashmap countTimes and restart sweeping after that word.
 *
 */
public class H30_SubstringwithConcatenationofAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> result = new ArrayList<>();
        if (words.length == 0) return result;
        int wordLength = words[0].length();

        HashMap<String, Integer> times = new HashMap<>();
        for (String word : words) {
            times.put(word, times.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int count = 0;
            HashMap<String, Integer> countTimes = new HashMap<>();
            for (int j = i; j <= s.length() - wordLength; j += wordLength) {
                String str = s.substring(j, j + wordLength);
                if (times.containsKey(str)) {
                    countTimes.put(str, countTimes.getOrDefault(str, 0) + 1);
                    if (countTimes.get(str) <= times.get(str)) {
                        count++;
                    }
                    else {
                        while (countTimes.get(str) > times.get(str)) {
                            String popStr = s.substring(left, left + wordLength);
                            System.out.println(popStr);
                            System.out.println(j);
                            countTimes.put(popStr, countTimes.get(popStr) - 1);
                            left += wordLength;
                            if (countTimes.get(popStr) < times.get(popStr)) count--; //only sweep to the repeat string
                        }
                    }
                    if (count == words.length) {
                        result.add(left);
                        String popStr = s.substring(left, left + wordLength);
                        countTimes.put(popStr, countTimes.get(popStr) - 1);
                        count--;
                        left += wordLength;
                    }
                }
                else {
                    countTimes.clear();
                    count = 0;
                    left = j + wordLength;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "abababab";
        String[] words = {"ab","ba"};
        System.out.println(findSubstring(s,words));
    }
}
