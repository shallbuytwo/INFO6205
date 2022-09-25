public class Q2 {
    public static ListNode removeElements(ListNode head, int val) {
        // Create a dummy node to simply the handling of some edge cases.
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = head;
        ListNode pre = dummy;

        while (cur != null) {
            if (cur.val != val) {
                // If cur.val isn't what we look for, we move on.
                pre = cur;
            } else {
                // If cur.val is what we look for, we skip/remove the cur node.
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
