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
        if(head==null){
            return null;
        }
        int n=0;
        ListNode cur=head;
        while(cur!=null){
            n++;
            cur=cur.next;
        }
        k=k%n;
        if(k==0){
            return head;
        }
        cur=head;
        ListNode headRot=null;
        int count=0;
        while(count<n-k-1){
            cur=cur.next;
            count++;
        }
        headRot=cur.next;
        cur.next=null;
        cur=headRot;
        while(cur.next!=null){
            cur=cur.next;
        }
        //System.out.println(cur.val);
        cur.next=head;
        return headRot;
    }
}