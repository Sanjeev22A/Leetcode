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
    int cache;
    int maxPath(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=maxPath(root.left);
        int right=maxPath(root.right);
        if(left<0){
            left=0;
        }
        if(right<0){
            right=0;
        }
        //System.out.println(left+":"+right+":"+root.val);
        cache=Math.max(root.val+left+right,cache);
        return Math.max(left,right)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        cache=Integer.MIN_VALUE;
        int val=maxPath(root);
        cache=Math.max(cache,val);
        return cache;

    }
}