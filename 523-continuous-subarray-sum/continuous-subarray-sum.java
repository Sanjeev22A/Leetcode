class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> remMap=new HashMap<>();
       
        int[] prefixSum=new int[nums.length];
        prefixSum[0]=nums[0];
        remMap.put(nums[0]%k,0);
        for(int i=1;i<nums.length;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
            int rem=prefixSum[i]%k;
            //System.out.println(rem);
            if(rem==0){
                
                return true;
            }
            if(remMap.containsKey(rem) && remMap.get(rem)+1!=i){
                return true;
            }
            
            if(!remMap.containsKey(rem)){
                remMap.put(rem,i);
            }
        }
        return false;

    }
}