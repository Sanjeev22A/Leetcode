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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> bfs=new LinkedList<>();
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> ans=new ArrayList<>();
        bfs.offer(root);
        while(!bfs.isEmpty()){
            int a=bfs.size();
            
            for(int i=0;i<a;i++){
                
                TreeNode cur=bfs.poll();
                if(i==a-1){
                    ans.add(cur.val);
                }
                if(cur.left!=null){
                    bfs.offer(cur.left);
                }
                if(cur.right!=null){
                    bfs.offer(cur.right);
                }
            }


        }
        return ans;
    }
}