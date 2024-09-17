class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> dp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!dp.containsKey(nums[i])){
                dp.put(nums[i],i);
            }
            else{
                if(Math.abs(i-dp.get(nums[i]))<=k){
                    return true;
                }
                else{
                    dp.put(nums[i],i);
                }
            }
        }

        return false;
    }
}