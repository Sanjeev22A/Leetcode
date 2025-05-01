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
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(0,nums.length-1,nums);
    }
    TreeNode build(int l,int r,int[] nums){
        if(l>r){return null;}
        else{
            int mid=(l+r)/2;
            TreeNode a=new TreeNode(nums[mid]);
            a.left=build(l,mid-1,nums);
            a.right=build(mid+1,r,nums);
            return a;
        }
    }
}