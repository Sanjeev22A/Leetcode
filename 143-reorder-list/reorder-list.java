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
    ListNode rev(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
    ListNode merge(ListNode s1,ListNode s2){
        ListNode head=null;
        ListNode temp=null;
        while(s1!=null || s2!=null){
            if(head==null){
                head=s1;
                temp=s1;
                s1=s1.next;
            }else if(s1!=null){
                
                temp.next=s1;
                temp=temp.next;
                s1=s1.next;
            }
            
            if(s2!=null){
                temp.next=s2;
                temp=temp.next;
                s2=s2.next;
            }
            
        }
        return head;
    }
    public void reorderList(ListNode head) {
        ListNode start1=head;
        ListNode start2=head;
        ListNode slow=head;
        ListNode fast=head;
        ListNode temp2=null;
        while(fast!=null){
            temp2=slow;
            slow=slow.next;
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
            }
        }
        start1=head;
        start2=slow;
        temp2.next=null;
        
        start2=rev(start2);
        ListNode cur=null;
        head=merge(start1,start2);
        return;
    }
}