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
    int returnMaxSize(TreeNode root,int val){
        if(root==null){
            return 0;
        }
        val=Math.max(root.val,val);
        val=Math.max(val,returnMaxSize(root.left,val));
        val=Math.max(val,returnMaxSize(root.right,val));
        return val;
    }
    void populateGraph(TreeNode root,List<List<Integer>> graph){
        if(root==null){
            return;
        }
        
        if(root.left!=null){
            graph.get(root.val).add(root.left.val);
            graph.get(root.left.val).add(root.val);
        }
        if(root.right!=null){
            graph.get(root.val).add(root.right.val);
            graph.get(root.right.val).add(root.val);
        }
        populateGraph(root.left,graph);
        populateGraph(root.right,graph);
    }
    public int amountOfTime(TreeNode root, int start) {
        List<List<Integer>> graph=new ArrayList<>();
        int size=returnMaxSize(root,0)+1;
        for(int i=0;i<size;i++){
            graph.add(new ArrayList<>());
        }
        populateGraph(root,graph);

        Queue<Integer> queue=new LinkedList<>();
        queue.offer(start);
        int count=0;
        boolean[] visited=new boolean[graph.size()];
        while(!queue.isEmpty()){
            size=queue.size();
            
            for(int i=0;i<size;i++){
                int cur=queue.poll();
                visited[cur]=true;
                for(int a:graph.get(cur)){
                    if(!visited[a]){
                        queue.offer(a);
                    }
                }
            }
            count++;

        }
        return count-1;
    }
}