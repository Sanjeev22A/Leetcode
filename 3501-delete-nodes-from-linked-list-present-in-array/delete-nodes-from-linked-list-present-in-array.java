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
class Solution {
    boolean in(int val,Set<Integer> nums){
       return nums.contains(val);
    }
    ListNode delete(ListNode head,Set<Integer> nums){
        while(head != null && in(head.val,nums)){
            head=head.next;
        }
        ListNode prev=head;
        ListNode current=null;
        if(head != null){
            current=head.next;
        }
        while(current != null){
            if(in(current.val,nums)){
                prev.next=current.next;
                
            }
            else{
            prev=current;
            }
            current=current.next;
        }
        return head;
        
    }
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numSet = new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        return delete(head,numSet);
    }
   
}