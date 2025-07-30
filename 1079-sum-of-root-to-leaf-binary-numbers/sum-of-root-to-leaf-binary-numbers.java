class Solution {
    int val;

    boolean isLeaf(TreeNode cur) {
        return cur.left == null && cur.right == null;
    }

    void dfs(TreeNode cur, int curVal) {
        if (cur == null) return;

        curVal = (curVal << 1) | cur.val; 

        if (isLeaf(cur)) {
            val += curVal;
            return;
        }

        dfs(cur.left, curVal);
        dfs(cur.right, curVal);
    }

    public int sumRootToLeaf(TreeNode root) {
        val = 0;
        dfs(root, 0);
        return val;
    }
}
