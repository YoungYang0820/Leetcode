import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by yangjiawei on 2017/5/29.
 */
public class M582_KillProcess {
    public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int parentID = ppid.get(i);
            map.putIfAbsent(parentID, new HashSet<Integer>());
            map.get(parentID).add(pid.get(i));
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(kill);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            result.add(node);
            if (map.containsKey(node)) {
                for (int num : map.get(node))
                    stack.push(num);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Integer> pid = new ArrayList<>();
        ArrayList<Integer> ppid = new ArrayList<>();
        pid.add(1);
        pid.add(3);
        pid.add(10);
        pid.add(5);
        ppid.add(3);
        ppid.add(0);
        ppid.add(5);
        ppid.add(3);
        List<Integer> result = killProcess(pid, ppid, 5);
        for (int num : result)
            System.out.println(num);
    }
}
