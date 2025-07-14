/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1=headA;
        ListNode t2=headB;
        int passCount=0;
        while(true){
            if(passCount>2){
                return null;
            }
            if(t1==t2){
                return t1;
            }
            t1=t1.next;
            t2=t2.next;
            if(t1==null){
                t1=headB;
                passCount++;
            }
            if(t2==null){
                t2=headA;
                passCount++;
            }
        }
        //return null;
    }
}