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

    int rightRecurse(TreeNode root,int topVal){
        if(root==null){
            return topVal;
        }
        int rightSum=rightRecurse(root.right,topVal);
        int curUpdate=root.val+rightSum;
        root.val=curUpdate;
        int returnVal=rightRecurse(root.left,curUpdate);
        return returnVal;
    }
    public TreeNode convertBST(TreeNode root) {
        rightRecurse(root,0);
        return root;
    }
}