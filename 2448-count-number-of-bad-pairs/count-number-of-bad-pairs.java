class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer,Long> counter=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int val=nums[i]-i;
            counter.put(val,counter.getOrDefault(val,Long.valueOf(0))+1);

        }
        long total=(long)nums.length*(nums.length-1)/2;
        long count=0;
        for(Map.Entry<Integer,Long> e:counter.entrySet()){
            count+=(e.getValue()*(e.getValue()-1))/2;

        }
        return total-count;
    }
}