import java.util.HashMap;

/**
 * Created by yangjiawei on 2017/5/2.
 */
public class E389_FindTheDifference {
    public char findTheDifference(String s, String t) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//        }
//        for (int i = 0; i < t.length(); i++) {
//            if (!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) == 0) return t.charAt(i);
//            else map.replace(t.charAt(i), map.get(t.charAt(i)) - 1);
//        }
//        return 'a';

        /*
        Using Bit Manipulation
         */
        char result = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            result ^= s.charAt(i);
            result ^= t.charAt(i);
        }
        return result;
    }
}
