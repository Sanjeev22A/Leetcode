class Solution {
    public int maximumDifference(int[] nums) {
        int minPrev=nums[0];
        int ans=0;
        for(int i=1;i<nums.length;i++){
            ans=Math.max(nums[i]-minPrev,ans);
            minPrev=Math.min(minPrev,nums[i]);
        }
        if(ans==0){
            return -1;
        }
        return ans;
    }
}