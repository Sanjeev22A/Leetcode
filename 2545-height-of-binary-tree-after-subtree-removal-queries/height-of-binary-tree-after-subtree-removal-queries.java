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
    int height(TreeNode root,HashMap<Integer,Integer> heights){
        if(root==null){
            return -1;
        }
        int height=Math.max(height(root.left,heights),height(root.right,heights))+1;
        heights.put(root.val,height);
        return height;
    }
    void solutionMaker(TreeNode root,HashMap<Integer,Integer> heights,HashMap<Integer,Integer> answer){
        Queue<TreeNode> q=new LinkedList<>();
        
        q.add(root);
        int levelDepth=0;
        while(!q.isEmpty()){
            int maxHeight=Integer.MIN_VALUE;
            int max2Height=Integer.MIN_VALUE;
            int size=q.size();
             for (TreeNode cur : q) { 
            int h = heights.get(cur.val);
            if (h > maxHeight) {
                max2Height = maxHeight;
                maxHeight = h;
            } else if (h >= max2Height) {
                max2Height = h;
            }
            }
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                int h=heights.get(cur.val);
                if(h==maxHeight){
                    if(max2Height==Integer.MIN_VALUE){
                        answer.put(cur.val,levelDepth-1);
                    }
                    else{
                    answer.put(cur.val,levelDepth+max2Height);
                    }
                }
                else{
                    answer.put(cur.val,levelDepth+maxHeight);
                }
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }
            }
            levelDepth++;


        }

    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        HashMap<Integer,Integer> heights=new HashMap<>();
        heights.put(null,0);
        height(root,heights);
        HashMap<Integer,Integer> answer=new HashMap<>();
        solutionMaker(root,heights,answer);
        int[] result=new int[queries.length];
        int i=0;
        for(int a:queries){
            result[i++]=answer.get(a);
        }
        return result;
        

    }
}