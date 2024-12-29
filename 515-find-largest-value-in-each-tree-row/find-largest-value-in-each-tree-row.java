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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largest=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return largest;
        }
        TreeNode cur=root;
        queue.offer(cur);
        while(!queue.isEmpty()){
            int max=Integer.MIN_VALUE;
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode val=queue.poll();
                if(val.val>max){
                    max=val.val;
                }
                if(val.left!=null){queue.offer(val.left);}
                if(val.right!=null){queue.offer(val.right);
                }

            }
            largest.add(max);
        }
        return largest;
        
    }
}