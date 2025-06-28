/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode LCA=null;
    boolean[] haveSeen(TreeNode root,TreeNode p,TreeNode q){
        
        if(root==null){
            return new boolean[2];
        }
        boolean[] arr1=haveSeen(root.left,p,q);
        boolean[] arr2=haveSeen(root.right,p,q);
        if(LCA!=null){
            return new boolean[2];
        }
        boolean[] ans=new boolean[2];
        if(root==p){
            ans[0]=true;
        }if(root==q){
            ans[1]=true;
        }
        ans[0]=ans[0]|arr1[0]|arr2[0];
        ans[1]=ans[1]|arr1[1]|arr2[1];
        if(ans[0] && ans[1]){
            LCA=root;
        }
        return ans;
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        haveSeen(root,p,q);
        return LCA;
    }
}