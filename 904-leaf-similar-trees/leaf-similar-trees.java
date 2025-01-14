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
    boolean isLeaf(TreeNode leaf){
        if(leaf==null){
            return false;
        }
        if(leaf.left==null && leaf.right==null){
            return true;
        }
        return false;
    }
    void produceLeaf(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        if(isLeaf(root)){
            list.add(root.val);
        }
        produceLeaf(root.left,list);
        produceLeaf(root.right,list);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        produceLeaf(root1,l1);
        produceLeaf(root2,l2);
        System.out.println(l1);
        System.out.println(l2);
        return l1.equals(l2);
    }
}