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
    int getIdx(int i,int length){
        if(i>=0 && i<=(length/2-1)){
            return i;
        }else{
            return length-i-1;
        }
    }
    public int pairSum(ListNode head) {
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        int[] aggregate=new int[length/2];
        int i=0;
        while(head!=null){
            int idx=getIdx(i,length);
            aggregate[idx]+=head.val;
            head=head.next;
            i++;
        }      
        int max=0;
        for(int a:aggregate){
            max=Math.max(a,max);
        }
        return max;
       
    }
}