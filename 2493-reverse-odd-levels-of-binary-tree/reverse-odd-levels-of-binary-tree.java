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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<TreeNode> res=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if(cur.left != null){
                    res.add(cur.left);
                    queue.offer(cur.left);
                }

                if(cur.right!=null){
                        res.add(cur.right);
                        queue.offer(cur.right);
                }
                    
                


            }
            if(level%2==0){
                    int left=0,right=res.size()-1;
                    while(left<right){
                        TreeNode l=res.get(left);
                        TreeNode r=res.get(right);
                        int temp=l.val;
                        l.val=r.val;
                        r.val=temp;
                        left++;
                        right--;
                    }
            }
            level++;
        }
        return root;
    }
}