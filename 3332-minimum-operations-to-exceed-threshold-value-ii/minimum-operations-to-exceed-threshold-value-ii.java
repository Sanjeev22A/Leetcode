class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> q=new PriorityQueue<>();
        for(int a:nums){
            q.add((long)a);
        }
        int numOp=0;
        while(q.peek()<k){
            long a=q.poll();
            long b=q.poll();
            q.add(Math.min(a,b)*2+Math.max(a,b));
            numOp++;
        }
        return numOp;
    }
}