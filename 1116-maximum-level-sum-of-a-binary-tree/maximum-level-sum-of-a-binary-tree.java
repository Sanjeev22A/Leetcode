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
    public int maxLevelSum(TreeNode root) {
        Long maxLevelSum=Long.MIN_VALUE;
        Queue<TreeNode> bfs=new LinkedList<>();
        int level=-1,i=1;
        if(root==null){return -1;}
        bfs.offer(root);
        while(!bfs.isEmpty()){
            int size=bfs.size();
            Long curSum=0l;
            for(int j=0;j<size;j++){
                TreeNode cur=bfs.poll();
                curSum+=cur.val;
                if(cur.left!=null){
                    bfs.offer(cur.left);
                }
                if(cur.right!=null){
                    bfs.offer(cur.right);
                }
            }
            if(curSum>maxLevelSum){
                level=i;
                maxLevelSum=curSum;
            }
            i++;
        }
        return level;
    }
}