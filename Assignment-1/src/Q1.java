public class Q1 {
    public static ListNode rotateRight(ListNode head, int k) {
        // Handle the case where the list has 0 or 1 node.
        if (head == null || head.next == null) {
            return head;
        }
        // Count how many nodes there are in the list.
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        // Handle the case where k >= n.
        k %= n;
        // If k % n == 0, we don't need to do anything.
        if (k == 0) {
            return head;
        }
        // Otherwise, let's locate where we need to split the list.
        ListNode middle = head;
        for (int i = 0; i < n - k - 1; i++) {
            middle = middle.next;
        }
        // Reconnect the list to satisfy the requirement.
        ListNode newHead = middle.next;
        middle.next = null;
        tail.next = head;

        return newHead;
    }
}
