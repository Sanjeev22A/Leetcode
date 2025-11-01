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
    int[] dfs(TreeNode root){
        if(root==null){
            return new int[]{0,0,0};
        }
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);
        int[] total=new int[]{left[0]+right[0]+root.val,left[1]+right[1]+1,left[2]+right[2]};
        int avg=total[0]/total[1];
        
        if(avg==root.val){
            total[2]++;
        }
        return total;
    }
    public int averageOfSubtree(TreeNode root) {
        int[] key=dfs(root);
        return key[2];
    }
}