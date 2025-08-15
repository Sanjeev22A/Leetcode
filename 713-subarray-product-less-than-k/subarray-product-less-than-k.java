class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=0){
            return 0;
        }
        int start=0,ans=0;
        long curProduct=1;
        for(int end=0;end<nums.length;end++){
            curProduct*=nums[end];
            while(start<=end && curProduct>=k){
                curProduct/=nums[start];
                start++;
            }
            ans+=(end-start+1);
        }
        return ans;
    }
}