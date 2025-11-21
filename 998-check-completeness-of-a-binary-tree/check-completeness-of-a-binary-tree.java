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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean prevLevelNotComplete=false;
        long levelSize=1L;
        while(!q.isEmpty()){
            int size=q.size();
            boolean prevNotPresent=false;
            
            for(int i=0;i<size;i++){
                
                TreeNode cur=q.poll();
                
                if(prevNotPresent && (cur.left!=null || cur.right!=null)){
                    return false;
                }
                if(cur.left!=null){
                    if(size!=levelSize){
                        return false;
                    }
                    q.offer(cur.left);
                }else{
                    prevLevelNotComplete=true;
                    prevNotPresent=true;
                }
                if(prevNotPresent && cur.right!=null){
                    return false;
                }
                if(cur.right!=null){
                    if(size!=levelSize){
                        return false;
                    }
                    q.offer(cur.right);
                }else{
                    prevLevelNotComplete=true;
                    prevNotPresent=true;
                }
            }
            levelSize<<=1;
        }
        return true;
    }
}