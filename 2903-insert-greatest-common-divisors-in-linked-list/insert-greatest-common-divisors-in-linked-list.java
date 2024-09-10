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
    int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp=head;
        while(temp!=null){
            int a=temp.val;
            if(temp.next==null){
                return head;
            }
            ListNode nextJump=temp.next;
            int b=temp.next.val;
            int gcd=gcd(a,b);
            ListNode newNode=new ListNode(gcd);
            newNode.next=temp.next;
            temp.next=newNode;
            temp=nextJump;
        }
        return head;
    }
}