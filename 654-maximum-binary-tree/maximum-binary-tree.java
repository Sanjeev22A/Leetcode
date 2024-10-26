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
    class Pair{
        int index,val;
        Pair(int index,int val){
            this.index=index;
            this.val=val;
        }
    }
    Pair getMax(int[] nums,int start,int end){
        if(start>=end){
            return new Pair(-1,-1);
        }
        int max=nums[start];
        int maxIndex=start;
        for(int i=start;i<end;i++){
            if(nums[i]>max){
                max=nums[i];
                maxIndex=i;
            }
        }
        return new Pair(maxIndex,max);
    }
    TreeNode construct(TreeNode root,int[] nums,int start,int end){
        Pair p=getMax(nums,start,end);
        if(p.val==-1){
            return null;
        }
        root.val=p.val;
        root.left=construct(new TreeNode(),nums,start,p.index);
        root.right=construct(new TreeNode(),nums,p.index+1,end);

        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(new TreeNode(),nums,0,nums.length);
    }
}