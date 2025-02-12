class Solution {
    private int digitSum(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num=num/10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        PriorityQueue<Integer>[] pq=new PriorityQueue[82];
        for(int i=0;i<82;i++){
            pq[i]=new PriorityQueue<Integer>();
        }
        for(int a:nums){
            int sum=digitSum(a);
            pq[sum].add(a);
            if(pq[sum].size()>2){
                pq[sum].poll();
            }
        }
        int maxSum=-1;
        for(PriorityQueue<Integer> minHeap:pq){
            if(minHeap.size()==2){
            int first=minHeap.poll();
            int second=minHeap.poll();
            maxSum=Math.max(maxSum,first+second);
            }
            
        }
        return maxSum;

    }
}