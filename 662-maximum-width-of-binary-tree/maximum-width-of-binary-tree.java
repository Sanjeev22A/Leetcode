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

 class Pair{
    TreeNode key;
    int index;
    Pair(TreeNode key,int index){
        this.key=key;
        this.index=index;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        int maxWidth=0;
        while(!q.isEmpty()){
            int size=q.size();
            Pair top=q.peek();
            int minIndex=top.index;
            for(int i=0;i<size;i++){
                Pair cur=q.poll();
                int curIndex=cur.index;
                maxWidth=Math.max(maxWidth,curIndex-minIndex+1);
                TreeNode t=cur.key;
                if(t.left!=null){
                    q.offer(new Pair(t.left,2*curIndex));

                }
                if(t.right!=null){
                    q.offer(new Pair(t.right,2*curIndex+1));
                }
            }
        }
        return maxWidth;
    }
}