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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev=null;
        ListNode cur=head;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            boolean isDuplicate=false;
            while(next!=null && cur.val==next.val){
                next=next.next;
                isDuplicate=true;
            }
            if(isDuplicate){
                if(prev==null){
                    head=next;
                    cur=head;
                    if(cur==null){
                        next=null;
                    }
                }else{
                    prev.next=next;
                    cur=prev.next;
                }
            }else{
                prev=cur;
                cur=next;
            }
            
        }
        return head;
    }
}