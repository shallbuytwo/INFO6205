public class Q2 {
    public static Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        Node leftHead = treeToDoublyList(root.left);
        Node rightHead = treeToDoublyList(root.right);
        Node leftTail;
        Node rightTail;

        if(leftHead != null) {
            leftTail = leftHead.left;
            root.left = leftTail;
            leftTail.right = root;
        }
        else {
            leftTail = leftHead = root;
        }
        if (rightHead != null) {
            rightTail = rightHead.left;
            root.right = rightHead;
            rightHead.left = root;
        }
        else {
            rightTail = rightHead = root;
        }
        leftHead.left = rightTail;
        rightTail.right = leftHead;
        return leftHead;
    }
}
