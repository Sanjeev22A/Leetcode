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
    int counter=0;
    
    public void dfs(TreeNode root,int max){
        if(root==null){
            return;
        }
        if(max<=root.val){
            counter++;
        }
        max=Math.max(root.val,max);
        dfs(root.left,max);
        dfs(root.right,max);
    }
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return counter;
    }
}