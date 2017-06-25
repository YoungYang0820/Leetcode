/**
 * Created by yangjiawei on 2017/6/25.
 */
public class M92_ReverseLinkedListII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode pre = sentinel;
        for (int i = 0; i < m - 1; i++) pre = pre.next;
        ListNode start = pre.next;
        ListNode target = start.next;
        for (int i = 0; i < n - m; i++) {
            start.next = target.next;
            target.next = pre.next;
            pre.next = target;
            target = start.next;
        }
        return sentinel.next;
    }
}
