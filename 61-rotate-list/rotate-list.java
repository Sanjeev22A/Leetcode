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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0){
            return head;
        }
        int n=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            n++;
        }
        
        k=k%n;

        int steps=n-k-1;
        cur=head;
        for(int i=0;i<steps;i++){
            cur=cur.next;
        }
        if(cur==null || k==0){
            return head;
        }
        ListNode newHead=cur.next;
        cur.next=null;
        cur=newHead;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=head;
        return newHead;
    }
}