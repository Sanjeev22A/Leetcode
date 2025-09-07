class Solution {
    public int maximumProduct(int[] nums, int k) {
        int mod=(int)Math.pow(10,9)+7;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(a,b));
        for(int a:nums){
            pq.offer(a);
        }
        for(int i=0;i<k;i++){
            int val=pq.poll();
            val++;
            pq.offer(val);
        }
        int product=1;
        while(!pq.isEmpty()){
            int val=pq.poll();
            product=(int)(((long)product*val)%mod);
        }
        return product;
    }
}