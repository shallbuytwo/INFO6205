public class Main {
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        for (int i = 1; i < arr.length; ++i) {
            ListNode newNode = new ListNode(arr[i]);
            tail.next = newNode;
            tail = newNode;
        }
        return head;
    }
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("(Empty Linked List)");
            return;
        }
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            System.out.print(" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Q1
        {
            int[] arr = {1, 2, 3, 4, 5};
            ListNode head = createList(arr);
            ListNode res = Q1.rotateRight(head, 2);
            printList(res);
            System.out.println();
        }

        // Q2
        {
            int[] arr = {1, 2, 6, 3, 4, 5, 6};
            ListNode head = createList(arr);
            ListNode res = Q2.removeElements(head, 6);
            printList(res);
            System.out.println();
        }

        // Q3
        {
            int[] arr = {1, 2, 3, 4, 5};
            ListNode head = createList(arr);
            ListNode res = Q3.swapNodes(head, 2);
            printList(res);
            System.out.println();
        }

        // Q4
        {
            int[] arr = {1, 2, 3};
            ListNode head = createList(arr);
            ListNode[] res = Q4.splitListToParts(head, 5);
            for (int i = 0; i < res.length; ++i) {
                printList(res[i]);
            }
            System.out.println();
        }

        // Q5
        {
            ListNode node1 = new ListNode(3);
            ListNode node2 = new ListNode(4);
            ListNode node3 = new ListNode(1);
            node1.next = node2;
            node2.next = node3;
            node3.next = node1;
            ListNode res = Q5.insert(node1, 2);

            // Iterate this circular list.
            ListNode cur = node1;
            while (true) {
                System.out.print(cur.val);
                System.out.print(" ");
                if (cur.next == node1) {
                    break;
                }
                cur = cur.next;
            }
            System.out.println();
        }
    }
}