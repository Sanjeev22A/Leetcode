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
    int ans;
    public int sumNumbers(TreeNode root) {
        ans=0;
        dfs(root,new StringBuilder());
        return ans;
    }
    boolean checkIfLeaf(TreeNode root){
        if(root.left==null && root.right==null){
            return true;
        }
        return false;
    }
    void dfs(TreeNode root,StringBuilder s){
        if(root==null){
            return;
        }
        s.append(Integer.toString(root.val));
        if(checkIfLeaf(root)){
            
            ans+=Integer.parseInt(s.toString());
        }else{
            
            StringBuilder left=new StringBuilder(s);
            StringBuilder right=new StringBuilder(s);
            dfs(root.left,left);
            dfs(root.right,right);
        }
    }
}