/**
 * Created by yangjiawei on 2017/5/27.
 */
public class M147_InsertionSortList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode insertionSortList(ListNode head) {
        ListNode sorted = new ListNode(0);
        ListNode cursor = head;
        while (cursor != null) {
            ListNode newCursor = sorted;
            while (newCursor.next != null && newCursor.next.val < cursor.val) {
                newCursor = newCursor.next;
            }
            ListNode next = newCursor.next;
            newCursor.next = new ListNode(cursor.val);
            newCursor.next.next = next;
            cursor = cursor.next;
        }
        return sorted.next;
    }
}
