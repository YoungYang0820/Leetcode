import javax.swing.tree.TreeNode;
import java.util.Stack;

/**
 * Created by yangjiawei on 2017/6/1.
 */
public class E173_BSTiterator {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    Stack<TreeNode> stack;
    public E173_BSTiterator(TreeNode root) {
        stack = new Stack<>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode result = stack.pop();
        TreeNode node = result.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return result.val;
    }
}