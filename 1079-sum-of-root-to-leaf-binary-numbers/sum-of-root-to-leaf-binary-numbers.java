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
    int val;
    
    boolean isLeaf(TreeNode cur){
        if(cur.left==null && cur.right==null){
            return true;
        }
        return false;
    }
    void ans(TreeNode cur,int curVal){
        if(cur==null){
            return;
        }
        
        curVal=(curVal<<1)+cur.val;
        
        if(isLeaf(cur)){
            
            val+=curVal;
            return;
        }
        ans(cur.left,curVal);
        ans(cur.right,curVal);

    }
    public int sumRootToLeaf(TreeNode root) {
        val=0;
        ans(root,0);
        return val;
    }
}