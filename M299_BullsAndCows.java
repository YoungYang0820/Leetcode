import java.util.HashMap;

/**
 * Created by yangjiawei on 2017/6/16.
 */
public class M299_BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        HashMap<Character, Integer> all = new HashMap<>();
        for (char ch : secret.toCharArray()) {
            all.put(ch, all.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                all.put(guess.charAt(i), all.get(guess.charAt(i)) - 1);
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i) && all.getOrDefault(guess.charAt(i), 0) > 0) {
                cows++;
                all.put(guess.charAt(i), all.get(guess.charAt(i)) - 1);
            }
        }
        return bulls + "A" + cows + "B";
    }
}
