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
        int[] rec=new int[1];
        rec[0]=root.val;
        dfs(root,rec);
        return rec[0];
    }

    int dfs(TreeNode root,int[] rec){
        if(root==null){
            return 0;
        }
        int left=Math.max(0,dfs(root.left,rec)); //Dont include negative
        int right=Math.max(0,dfs(root.right,rec));
        int cur=root.val+left+right;
        rec[0]=Math.max(rec[0],cur);
        return Math.max(left,right)+root.val;
    }
}