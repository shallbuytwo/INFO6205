import apple.laf.JRSUIUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Q1
        {
            TreeNode left = new TreeNode(2);
            TreeNode right = new TreeNode(2);
            TreeNode root = new TreeNode(1, left, right);
            System.out.println(Q1.isSymmetric(root));
        }
        // Q2
        {
            TreeNode l2l = new TreeNode(15);
            TreeNode l2r = new TreeNode(7);
            TreeNode l1l = new TreeNode(9);
            TreeNode l1r = new TreeNode(20, l2l, l2r);
            TreeNode root = new TreeNode(3, l1l, l1r);
            System.out.println(Q2.maxDepth(root));
        }
        // Q3
        {
            TreeNode l2a = new TreeNode(5);
            TreeNode l2b = new TreeNode(4);
            TreeNode l1a = new TreeNode(2, null, l2a);
            TreeNode l1b = new TreeNode(3, null, l2b);
            TreeNode root = new TreeNode(1, l1a, l1b);
            for (Integer i : Q3.rightSideView(root)) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
        // Q4
        {
            TreeNode l2l = new TreeNode(15);
            TreeNode l2r = new TreeNode(7);
            TreeNode l1l = new TreeNode(9);
            TreeNode l1r = new TreeNode(20, l2l, l2r);
            TreeNode root = new TreeNode(3, l1l, l1r);

            System.out.println();
            for (List<Integer> l : Q4.zigzagLevelOrder(root)) {
                for (Integer i : l) {
                    System.out.print(i);
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        // Q5
        {
            TreeNode l2l = new TreeNode(15);
            TreeNode l2r = new TreeNode(7);
            TreeNode l1l = new TreeNode(9);
            TreeNode l1r = new TreeNode(20, l2l, l2r);
            TreeNode root = new TreeNode(3, l1l, l1r);
            System.out.println();
            for (List<Integer> l : Q5.verticalOrder(root)) {
                for (Integer i : l) {
                    System.out.print(i);
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();

        }
        // Q6
        {
            TreeNode l2a = new TreeNode(5);
            TreeNode l2b = new TreeNode(3);
            TreeNode l2c = new TreeNode(9);
            TreeNode l1l = new TreeNode(3, l2a, l2b);
            TreeNode l1r = new TreeNode(2, null, l2c);
            TreeNode root = new TreeNode(1, l1l, l1r);
            System.out.println(Q6.widthOfBinaryTree(root));
        }
        // Q7
        {
            TreeNode l2a = new TreeNode(5);
            TreeNode l2b = new TreeNode(3);
            TreeNode l2c = new TreeNode(9);
            TreeNode l1l = new TreeNode(3, l2a, l2b);
            TreeNode l1r = new TreeNode(2, null, l2c);
            TreeNode root = new TreeNode(1, l1l, l1r);
            System.out.println(Q7.lowestCommonAncestor(root, l2a, l2c).getVal());
        }
        // Q8
        {
            TreeNode l2a = new TreeNode(4);
            TreeNode l2b = new TreeNode(5);
            TreeNode l1l = new TreeNode(2, l2a, l2b);
            TreeNode l1r = new TreeNode(3);
            TreeNode root = new TreeNode(1, l1l, l1r);
            Q8 q = new Q8();

            System.out.println();
            for (List<Integer> l : q.findLeaves(root)) {
                for (Integer i : l) {
                    System.out.print(i);
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}