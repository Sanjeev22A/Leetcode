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
    TreeNode node;
    boolean state;
    Pair(TreeNode node,Boolean state){
        this.node=node;
        this.state=state;
    }
    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(!(o instanceof Pair)){
            return false;
        }
        Pair cur=(Pair)o;
        return cur.node==node && cur.state==state;
    }
    @Override
    public int hashCode(){
        return Objects.hash(node,state);
    }
 }
class Solution {
    Map<Pair,Integer> map;
    int maxRob(TreeNode root,boolean previous){
        if(root==null){
            return 0;
        }
        Pair cur=new Pair(root,previous);
        if(map.containsKey(cur)){
            return map.get(cur);
        }
        if(previous){
            
            int val=maxRob(root.left,false)+maxRob(root.right,false);
            map.put(cur,val);
            return val;
        }else{
            int ifRoot=root.val+maxRob(root.left,true)+maxRob(root.right,true);
            int notRoot=maxRob(root.left,false)+maxRob(root.right,false);
            int val=Math.max(ifRoot,notRoot);
            map.put(cur,val);
            return val;
        }
    }
    public int rob(TreeNode root) {
        map=new HashMap<>();
        return Math.max(maxRob(root,true),maxRob(root,false));
    }
}