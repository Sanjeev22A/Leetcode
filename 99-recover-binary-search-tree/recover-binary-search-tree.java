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
    TreeNode first,second,prev;
    void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        
        if(first==null && prev.val>root.val){
            first=prev;
        }
        if(first!=null && prev.val>root.val){
            second=root;
        }    
        
        prev=root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first=null;
        second=null;
        prev=new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
}