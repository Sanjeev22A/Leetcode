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
    ListNode reverse(ListNode node){
        ListNode prev=null;
        ListNode cur=node;
        ListNode next=null;
        while(cur!=null){
            
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode ans=dfs(l1,l2,0);
        return ans;
    }
    ListNode dfs(ListNode l1,ListNode l2,int carry){
       if(l1==null && l2==null && carry==0){
        return null;
       }
       int temp1=l1!=null?l1.val:0;
       int temp2=l2!=null?l2.val:0;
       ListNode l1next=l1==null?null:l1.next;
       ListNode l2next=l2==null?null:l2.next;
       int ans=temp1+temp2+carry;
       
       ListNode cur=new ListNode(ans%10);
       ListNode next=dfs(l1next,l2next,ans/10);
       cur.next=next;
       return cur;
    }
}