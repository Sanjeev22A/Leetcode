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
    public Pair<TreeNode,Integer> postOrder(TreeNode root){
        if(root==null){return new Pair<>(null,0);}
        Pair<TreeNode,Integer> left=postOrder(root.left);
        Pair<TreeNode,Integer> right=postOrder(root.right);
        if(left.getValue()>right.getValue()){
            return new Pair<>(left.getKey(),left.getValue()+1);
        }
        else if(left.getValue()<right.getValue()){
            return new Pair<>(right.getKey(),right.getValue()+1);
        }
        return new Pair<>(root,left.getValue()+1);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return postOrder(root).getKey();
    }
}