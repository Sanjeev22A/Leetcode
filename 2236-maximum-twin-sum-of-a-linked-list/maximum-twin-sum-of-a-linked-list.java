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
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        int i=0;
        while(fast!=null){
            i++;
            fast=fast.next.next;
            slow=slow.next;

        }
        int[] arr=new int[i];
        int maxTwinSum=0;
        ListNode start=head;
        int n=2*i;
        int j=i-1;
        i=0;
    
        while(slow!=null){
            arr[i++]+=start.val;
            arr[j--]+=slow.val;
            slow=slow.next;
            start=start.next;
        }
        int maxVal=0;
        for(i=0;i<arr.length;i++){
            if(arr[i]>maxVal){
                maxVal=arr[i];
            }
        }
        return maxVal;
    }
}