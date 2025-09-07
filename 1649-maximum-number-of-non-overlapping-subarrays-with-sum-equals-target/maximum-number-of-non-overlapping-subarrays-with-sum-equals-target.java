class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Long,Integer> map=new HashMap<>();
        long prefixSum=0L;
        int prev=-2;
        int count=0;
        map.put(0L,-1);
        for(int i=0;i<nums.length;i++){
            prefixSum+=(long)nums[i];
            
            long rem=prefixSum-(long)target;
            int idx=map.getOrDefault(rem,-3);
            if(idx==-3){
                map.put(prefixSum,i);
                continue;
            }
            if(idx>=prev){
                count++;
                prev=i;
            }
            map.put(prefixSum,i);
        }
        return count;
    }
}