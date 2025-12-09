class Solution {
    int MOD=(int)Math.pow(10,9)+7;
    public int specialTriplets(int[] nums) {
        long ans=0L;
        Map<Integer,Long> count=new HashMap<>();
        long[] countBefore=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            countBefore[i]=count.getOrDefault(2*nums[i],0L);
            count.put(nums[i],count.getOrDefault(nums[i],0L)+1);
        }
        count=new HashMap<>();
        long[] countAfter=new long[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            countAfter[i]=count.getOrDefault(2*nums[i],0L);
            count.put(nums[i],count.getOrDefault(nums[i],0L)+1);
        }
        for(int i=1;i<nums.length-1;i++){
            long cur=(countBefore[i]*countAfter[i])%MOD;
            ans=((ans+cur)%MOD);
        }
        return (int)ans;
    }
}