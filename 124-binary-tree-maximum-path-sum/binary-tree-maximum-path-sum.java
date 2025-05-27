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
    public int maxPathSum(TreeNode root) {
        int[] cache=new int[1];
        cache[0]=root.val;
        dfs(root,cache);
        return cache[0];
    }

    int dfs(TreeNode root,int[] cache){
        if(root==null){
            return 0;
        }
        int left=Math.max(dfs(root.left,cache),0);
        int right=Math.max(dfs(root.right,cache),0);
        cache[0]=Math.max(cache[0],left+right+root.val);  //We assume left to right is a path
        return Math.max(left,right)+root.val; //Only one way we can take for a path
    }

}