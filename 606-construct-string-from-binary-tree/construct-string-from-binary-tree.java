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
    String ans;
    void dfs(TreeNode root,boolean flag){
        if(root==null){
            if(flag){
                ans+="()";
            }
            
            return;
        }
        ans+="("+root.val;
        boolean curflag=false;
        if(root.right!=null){
            curflag=true;
        }
        dfs(root.left,curflag);
        dfs(root.right,curflag);
        ans+=")";
    }
    public String tree2str(TreeNode root) {
        ans="";
        dfs(root,false);
        return ans.substring(1,ans.length()-1);
        //return ans;
    }
}