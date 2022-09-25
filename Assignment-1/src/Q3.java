public class Q3 {
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        // fast should move forward k - 1 steps first.
        for (int i = 0; i < k - 1; ++i) {
            fast = fast.next;
        }
        // Then the current "a" happens to be the node we need.
        ListNode a = fast;
        // Then we move fast again, but this time we also move slow.
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // When the while stops, slow will be the other node we need.
        ListNode b = slow;
        // Swap their values.
        int temp = a.val;
        a.val = b.val;
        b.val = temp;

        return head;
    }
}
