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
    List<List<Integer>> arr;
    int ans;
    public int sumNumbers(TreeNode root) {
        arr=new ArrayList<>();
        ans=0;
        dfs(root,new StringBuilder());
        
        return ans;
    }
    boolean checkIfLeaf(TreeNode root){
        if(root.left==null && root.right==null){return true;}
        return false;

    }
    void dfs(TreeNode root,StringBuilder s){
        if(root==null){
            return;
        }
        if(checkIfLeaf(root)){
            s.append(Integer.toString(root.val));
            //System.out.println
            ans+=Integer.parseInt(s.toString());
        }
        else{
            s.append(Integer.toString(root.val));
            StringBuilder left=new StringBuilder(s);
            StringBuilder right=new StringBuilder(s);
            dfs(root.left,left);
            dfs(root.right,right);
        }
    }
    
}