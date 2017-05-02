/**
 * Created by yangjiawei on 2017/5/2.
 */
public class E104_MaximumDepthOfBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int max) {
        if (root == null) return max;
        if (root.left == null && root.right == null) return max + 1;
        int left = helper(root.left, max + 1);
        int right = helper(root.right, max + 1);
        return left > right? left:right;
    }
}
