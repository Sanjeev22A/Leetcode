/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // DFS to calculate the height of each node
    int dfs(TreeNode root, Map<TreeNode, Integer> heights) {
        if(root == null) return 0;
        heights.put(root, 1 + Math.max(dfs(root.left, heights), dfs(root.right, heights)));
        return heights.get(root);
    }

    // DFS to calculate the answer for each node
    void dfs(TreeNode root, int d, int ans, int[] res, Map<TreeNode, Integer> heights) {
        if(root == null) return;
        res[root.val] = ans;
        // if left child of root is removed then the new height of the tree will be maximmum of (currentDepth + height of right subtree) or the previous calculated height
        dfs(root.left, d + 1, Math.max(ans, heights.get(root.right) + d), res, heights);
        dfs(root.right, d + 1, Math.max(ans, heights.get(root.left) + d), res, heights);
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        // map for storing height of each node
        Map<TreeNode, Integer> heights = new HashMap<>();
        
        // dfs to calculate the height of each node
        dfs(root, heights);

        // handle corner case, height of null node is 0
        heights.put(null, 0);

        // calculate the answer for each node
        int res[] = new int[heights.size() + 1];
        dfs(root, 0, -1, res, heights);

        int[] ans = new int[queries.length];
        int i = 0;
        for(int query: queries) {
            ans[i++] = res[query];
        }
        return ans;
    }
}