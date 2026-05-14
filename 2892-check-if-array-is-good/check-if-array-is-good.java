class Solution {
    public boolean isGood(int[] nums) {
        if(nums.length<2){
            return false;
        }
        Arrays.sort(nums);
        Set<Integer> set=new HashSet<>();
        int n=nums.length-2;
        set.add(nums[0]);
        for(int i=1;i<=n;i++){
            set.add(nums[i]);
            if(nums[i]!=nums[i-1]+1){
                return false;
            }
        }
        return set.size()==nums[n] && nums[n]==nums[n+1];
    }
}