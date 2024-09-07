/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private boolean isValid(ListNode cur,TreeNode root,ListNode head){
        if(cur==null){
            return true;
        }
        else if(cur!=null && root==null){
            return false;
        }
        else{
            if(cur.val==root.val){
                cur=cur.next;
            }
            else if(head.val==root.val){
                head=head.next;
            }
            else{
                cur=head;
            }
            return isValid(cur,root.left,head)|| isValid(cur,root.right,head);
        }
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        return isValid(head,root,head);
    }
}