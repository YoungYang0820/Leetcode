import java.util.HashSet;

/**
 * Created by yangjiawei on 2017/6/12.
 */
public class E575_DistributeCandies {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for (int candie : candies) {
            set.add(candie);
        }
        if (set.size() < candies.length / 2)
            return set.size();
        else
            return candies.length / 2;
    }
}
