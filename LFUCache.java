import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Created by yangjiawei on 2017/6/6.
 */
public class LFUCache {
    int capacity;
    int min;
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> list;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        min = 1;
        vals = new HashMap<>();
        counts = new HashMap<>();
        list = new HashMap<>();
        list.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!vals.containsKey(key)) return -1;
        int count = counts.get(key);
        counts.put(key, count + 1);
        list.get(count).remove(key);
        if (count == min && list.get(count).isEmpty())
            min = count + 1;
        if (!list.containsKey(count + 1))
            list.put(count + 1, new LinkedHashSet<>());
        list.get(count + 1).add(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }

        if (vals.size() >= capacity) {
            int out = list.get(min).iterator().next();
            list.get(min).remove(out);
            vals.remove(out);
            counts.remove(out);
        }
        vals.put(key, value);
        counts.put(key, 1);
        list.get(1).add(key);
        min = 1;
    }
}
