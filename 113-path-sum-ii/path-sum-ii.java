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
    boolean checkIfLeaf(TreeNode root){
        if(root.left==null && root.right==null){
            return true;
        }
        return false;
    }

    void dfs(TreeNode root,int sumLeft,List<List<Integer>> res,List<Integer> curPath){
        if(root==null){
            return;
        }
        if(sumLeft==root.val && checkIfLeaf(root)){
            curPath.add(root.val);
            res.add(curPath);
            return;
        }else if(checkIfLeaf(root)){
            return;
        }
        List<Integer> leftPath=new ArrayList<>(curPath);
        leftPath.add(root.val);
        List<Integer> rightPath=new ArrayList<>(curPath);
        rightPath.add(root.val);
        dfs(root.left,sumLeft-root.val,res,leftPath);
        dfs(root.right,sumLeft-root.val,res,rightPath);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(targetSum==0 && root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curPath=new ArrayList<>();
        dfs(root,targetSum,res,curPath);
        return res;
    }
}