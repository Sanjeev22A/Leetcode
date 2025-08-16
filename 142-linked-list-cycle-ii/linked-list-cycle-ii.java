/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    static class Point{
        boolean flag;
        ListNode node;
        Point(boolean flag,ListNode node){
            this.flag=flag;
            this.node=node;
        }
    }
    Point detectCycleFlag(ListNode head){
        ListNode slow=head,fast=head;
        do{
            if(fast==null || fast.next==null){
                return new Point(false,null);
            }
            fast=fast.next.next;
            slow=slow.next;
        }while(slow!=fast);
        return new Point(true,fast);
    }
    ListNode getStartNode(ListNode slow,ListNode fast){
        if(slow==fast){
            return slow;
        }
        do{
            slow=slow.next;
            fast=fast.next;
        }while(slow!=fast);
        return slow;
    }
    public ListNode detectCycle(ListNode head) {
        Point flag=detectCycleFlag(head);
        if(!flag.flag){
            return null;
        }
        return getStartNode(head,flag.node);
    }
}