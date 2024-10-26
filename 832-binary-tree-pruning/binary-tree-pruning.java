class Solution {  
    boolean logic(TreeNode root) {
        if (root == null) return false;

        boolean left = logic(root.left);
        boolean right = logic(root.right);

        if (!left) root.left = null;
        if (!right) root.right = null;

        return left || right || root.val == 1;
    }

    public TreeNode pruneTree(TreeNode root) {
        return logic(root) ? root : null;
    }
}
