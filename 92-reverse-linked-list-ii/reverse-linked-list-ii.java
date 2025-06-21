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
    ListNode reverseList(ListNode start,ListNode end){
        ListNode prev=null;
        ListNode cur=start;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return start;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }
        ListNode startAttachment=null;
        ListNode curLeft=head,curRight=head;
        int moveLeft=0;
        while(curLeft!=null && moveLeft<left-1){
            startAttachment=curLeft;
            curLeft=curLeft.next;
            moveLeft++;
        }
        int moveRight=0;

        while(curRight!=null && moveRight<right-1){
            curRight=curRight.next;
            moveRight++;
        }
        ListNode endAttachment=curRight.next;
        curRight.next=null;
        reverseList(curLeft,curRight);
        //System.out.println(curRight.val+":"+curLeft.val);
        if(startAttachment==null){
            head=curRight;
            startAttachment=curRight;

        }else{
            startAttachment.next=curRight;
        }
        //System.out.println(curRight.next.val);

        curLeft.next=endAttachment;
        
        return head;
    }
}