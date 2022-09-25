public class Q4 {
    public static ListNode[] splitListToParts(ListNode head, int k) {
        // List that stores the final result.
        ListNode[] res = new ListNode[k];
        if (head == null) {
            // Edge case if the list is null.
            // Fill every element to null.
            for (int i = 0; i < k; ++i) {
                res[i] = null;
            }
            return res;
        }
        // Count how many nodes there are.
        ListNode cur = head;
        int n = 1;
        while (cur.next != null) {
            cur = cur.next;
            ++n;
        }
        // Calculate how many elements each part should have,
        // as well as how many linked elements should have one more elements.
        // The first "longer" lists should have "size + 1" elements, while
        // the remaining "k - longer" lists should have "size" elements.
        int size = n / k;
        int longer = n % k;

        ListNode pre = null;
        cur = head;

        for (int i = 0; i < res.length; ++i) {
            // Terminate the previous linked list if needed.
            if (pre != null) {
                pre.next = null;
            }
            res[i] = cur;
            int steps = i < longer ? size + 1 : size;
            for (int j = 0; j < steps; ++j) {
                pre = cur;
                cur = cur.next;
            }
        }

        return res;
    }
}
