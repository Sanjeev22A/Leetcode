/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode head=node;
        ListNode prev=node;
        while(head.next!=null){
            
            head.val=head.next.val;
            prev=head;
            head=head.next;
        }
        prev.next=null;

    }
}