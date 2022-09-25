public class Q5 {
    public static ListNode insert(ListNode head, int insertVal) {
        // Edge case - if the list is empty.
        if (head == null) {
            head = new ListNode(insertVal);
            head.next = head;
            return head;
        }
        // Otherwise, go over this list.
        ListNode pre = head;
        ListNode cur = head.next;
        boolean toInsert = false;
        while (true) {
            if (pre.val <= insertVal && insertVal <= cur.val) {
                // If we found a place to insert between pre and cur.
                toInsert = true;
            } else if (pre.val > cur.val) {
                // If we found the maximum and minimum values in this circular list...
                if (insertVal >= pre.val || insertVal <= cur.val) {
                    // and if insertVal can be put in between...
                    toInsert = true;
                }
            }
            if (toInsert) {
                break;
            }
            pre = cur;
            cur = cur.next;
            if (pre == head) {
                // This is handling the case where all the elements are the same in the list.
                break;
            }
        }
        // Actually insert the node.
        ListNode newNode = new ListNode(insertVal, cur);
        pre.next = newNode;
        return head;
    }
}
