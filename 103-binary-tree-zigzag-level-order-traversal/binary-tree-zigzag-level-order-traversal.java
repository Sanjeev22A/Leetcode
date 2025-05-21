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
        int level=1;
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> res=new ArrayList<>();
        Deque<TreeNode> dq=new ArrayDeque<>();
        dq.addLast(root);
        while(!dq.isEmpty()){
            int a=dq.size();
            List<Integer> t=new ArrayList<>();
            
            for(int i=0;i<a;i++){
                TreeNode temp=null;
                if(level==1){
                    temp=dq.pollFirst();
                    t.add(temp.val);
                    if(temp.left!=null){dq.addLast(temp.left);}
                    if(temp.right!=null){dq.addLast(temp.right);}
                }else{
                    temp=dq.pollLast();
                    t.add(temp.val);
                    if(temp.right!=null){
                        dq.addFirst(temp.right);
                    }
                    if(temp.left!=null){
                        dq.addFirst(temp.left);
                    }
                }
                
                
            }
            


            level=(level+1)%2;
            System.out.println(level);
            res.add(t);
        }
        return res;
    }
}