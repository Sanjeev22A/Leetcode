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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> dq=new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return new ArrayList<>();
        }
        dq.add(root);
        int level=1;
        while(!dq.isEmpty()){
            int a=dq.size();
            
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<a;i++){
                if(level==1){
                    TreeNode q=dq.pollFirst();
                    temp.add(q.val);
                    if(q.left!=null){
                        dq.addLast(q.left);
                    }
                    if(q.right!=null){
                        dq.addLast(q.right);
                    }
                }
                else{
                    TreeNode q=dq.pollLast();
                    temp.add(q.val);
                    if(q.right!=null){
                        dq.addFirst(q.right);
                    }if(q.left!=null){
                        dq.addFirst(q.left);
                    }
                }
            }
            level=(level+1)%2;
            res.add(temp);
        }
        return res;
    }
}