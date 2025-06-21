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
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        ListNode lst1=new ListNode();
        ListNode lst2=new ListNode();
        ListNode head1=lst1,head2=lst2;
        ListNode cur=head;
        ListNode prevlst1=lst1,prevlst2=lst2;
        boolean lesserSeen=false,greaterSeen=false;
        while(cur!=null){
            if(cur.val>=x){
                lst2.val=cur.val;
                lst2.next=new ListNode();
                prevlst2=lst2;
                lst2=lst2.next;
                greaterSeen=true;
            }else{
                lst1.val=cur.val;
                lst1.next=new ListNode();
                prevlst1=lst1;
                lst1=lst1.next;
                lesserSeen=true;
            }
            cur=cur.next;
        }
       if(!greaterSeen){
        prevlst1.next=null;
        return head1;
       }else if(!lesserSeen){
        prevlst2.next=null;
        return head2;
       }
        prevlst1.next=head2;
        prevlst2.next=null;
        return head1;
        
    }
}