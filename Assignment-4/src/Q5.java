import java.util.Stack;

public class Q5 {
    private Stack<TreeNode> stack = new Stack<>();
    private void pushLeft(TreeNode p) {
        while (p != null) {
            stack.add(p);
            p = p.left;
        }
    }

    public Q5(TreeNode root) {
        pushLeft(root);

    }

    public int next() {
        TreeNode p = stack.pop();
        pushLeft(p.right);
        return p.val;

    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
