import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yangjiawei on 2017/5/3.
 */
public class M127_WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> list = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visitedSet = new HashSet<>();
        int len = 1;
        int strLen = beginWord.length();
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] charWords = word.toCharArray();
                for (int i = 0; i < strLen; i++) {
                    for (char c = 'a'; c < 'z'; c++) {
                        char old = charWords[i];
                        charWords[i] = c;
                        String target = String.valueOf(charWords);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visitedSet.contains(target) && list.contains(target)) {
                            temp.add(target);
                            visitedSet.add(target);
                        }
                        charWords[i] = old;
                    }
                }
            }
            len++;
            beginSet = temp;
        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("dbc");
        list.add("dec");
        System.out.println(ladderLength("abc", "dec", list));
    }
}
