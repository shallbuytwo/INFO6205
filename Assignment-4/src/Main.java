public class Main {
    private static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        System.out.print(" ");
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
    }
    public static void main(String[] args) {
        // Q1
        {
            ListNode tail = new ListNode(9);
            ListNode c = new ListNode(5, tail);
            ListNode b = new ListNode(0, c);
            ListNode a = new ListNode(-3, b);
            ListNode head = new ListNode(-10, a);
            TreeNode root = Q1.sortedListToBST(head);
            inOrderTraversal(root);
            System.out.println();
        }
        // Q2
        {
            Node l2l = new Node(1);
            Node l2r = new Node(3);
            Node l1l = new Node(2, l2l, l2r);
            Node l1r = new Node(5);
            Node root = new Node(4, l1l, l1r);

            Node head = Q2.treeToDoublyList(root);
            Node cur = head;
            while (true){
                System.out.print(cur.val);
                cur = cur.right;
                if(cur.val == head.val) {
                    break;
                }
            }
            System.out.println();
        }
        // Q3
        {
            TreeNode a = new TreeNode(1);
            TreeNode b = new TreeNode(3);
            TreeNode root = new TreeNode(2, a, b);
            System.out.println(Q3.isValidBST(root));

            TreeNode l2l = new TreeNode(3);
            TreeNode l2r = new TreeNode(6);
            TreeNode l1l = new TreeNode(1);
            TreeNode l1r = new TreeNode(4, l2l, l2r);
            TreeNode root1 = new TreeNode(5, l1l, l1r);
            System.out.println(Q3.isValidBST(root1));

        }
        // Q4
        {
            TreeNode l2 = new TreeNode(2);
            TreeNode l1 = new TreeNode(3, null, l2);
            TreeNode root = new TreeNode(1, l1, null);
            Q4.recoverTree(root);
            inOrderTraversal(root);
            System.out.println();
        }
        // Q5
        {
            TreeNode l2l = new TreeNode(9);
            TreeNode l2r = new TreeNode(20);
            TreeNode l1l = new TreeNode(3);
            TreeNode l1r = new TreeNode(15, l2l, l2r);
            TreeNode root = new TreeNode(7, l1l, l1r);
            Q5 bstIterator = new Q5(root);
            while(bstIterator.hasNext()) {
                System.out.print(bstIterator.next());
                System.out.print(" ");
            }
            System.out.println();
        }
        // Q6
        {
            TreeNode l2l = new TreeNode(9);
            TreeNode l2r = new TreeNode(20);
            TreeNode l1l = new TreeNode(3);
            TreeNode l1r = new TreeNode(15, l2l, l2r);
            TreeNode root = new TreeNode(7, l1l, l1r);
            Q6 Codec = new Q6();
            System.out.print(Codec.serialize(root));
            //7,3,15,9,20,
            System.out.println();
            TreeNode root1 = Codec.deserialize("7,3,15,9,20,");
            inOrderTraversal(root1);
            System.out.println();
        }
        // Q7
        {
            TreeNode l2l = new TreeNode(9);
            TreeNode l2r = new TreeNode(20);
            TreeNode l1l = new TreeNode(3);
            TreeNode l1r = new TreeNode(15, l2l, l2r);
            TreeNode root = new TreeNode(7, l1l, l1r);
            TreeNode res = Q7.inorderSuccessor(root, l1r);
            System.out.println(res.val);

        }
        // Q8
        {
            TreeNode a = new TreeNode(3);
            TreeNode b = new TreeNode(7);
            TreeNode c = new TreeNode(18);
            TreeNode l = new TreeNode(5, a, b);
            TreeNode r = new TreeNode(15, null, c);
            TreeNode root = new TreeNode(10, l, r);
            System.out.println(Q8.rangeSumBST(root, 7, 15));

        }
    }
}