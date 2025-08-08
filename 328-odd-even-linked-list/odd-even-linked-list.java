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
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
            
        }
        ListNode odd=null;
        ListNode even=null;
        ListNode oddHead=null;
        ListNode evenHead=null;
        ListNode temp=head;
        while(temp!=null){
            if(oddHead==null){
                
                odd=temp;
                oddHead=odd;
                
                temp=temp.next;
                odd.next=null;
                even=temp;
                evenHead=even;
                if(temp!=null){
                    temp=temp.next;
                }
                if(even!=null){
                    even.next=null;
                }
            }
            else{
                odd.next=temp;
                odd=odd.next;
                
                temp=temp.next;
                odd.next=null;
                even.next=temp;
                if(temp!=null){
                    temp=temp.next;
                }
                even=even.next;
                if(even!=null){
                    even.next=null;
                }
            }

        }
        odd.next=evenHead;
        return oddHead;
    }
}