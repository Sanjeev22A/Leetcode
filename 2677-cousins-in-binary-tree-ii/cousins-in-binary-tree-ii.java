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
    HashMap<Integer,Integer> levelSum=new HashMap<>();
    void bfs(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int levelDepth=0;
        while(!q.isEmpty()){
            int size=q.size();
            int sum=0;
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                sum+=cur.val;
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }
            }
            levelSum.put(levelDepth,sum);
            levelDepth++;
        }
    }
    void inOrder(TreeNode root,Integer sibling,int level){
        if(root==null){
            return;
        }
        
        root.val=levelSum.get(level)-sibling-root.val;
        int leftsibling=0;
        int rightsibling=0;
        if(root.right!=null){
            leftsibling=root.right.val;
        }
        if(root.left!=null){
            rightsibling=root.left.val;
        }
        inOrder(root.left,leftsibling,level+1);
        inOrder(root.right,rightsibling,level+1);

    }
    public TreeNode replaceValueInTree(TreeNode root) {
        bfs(root);
        inOrder(root,0,0);
        return root;
    }
}