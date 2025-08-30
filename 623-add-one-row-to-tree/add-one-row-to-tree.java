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
    
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode q=new TreeNode(val);
            q.left=root;
            return q;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        depth--;
        int cur=1;
        while(!q.isEmpty()){
            if(cur==depth){
                int size=q.size();
                for(int i=0;i<size;i++){
                    TreeNode p=q.poll();
                    
                    TreeNode leftTemp=p.left;
                    TreeNode rightTemp=p.right;
                    p.left=new TreeNode(val);
                    p.right=new TreeNode(val);
           
                    p.left.left=leftTemp;
                    p.right.right=rightTemp;
                }
                cur++;
            }else{
                int size=q.size();
                for(int i=0;i<size;i++){
                    TreeNode p=q.poll();
                    if(p.left!=null){
                        q.offer(p.left);
                    }
                    if(p.right!=null){
                        q.offer(p.right);
                    }
                }
                cur++;
            }
        }
        return root;
    }
}