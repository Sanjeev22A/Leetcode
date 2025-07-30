class Solution {
    public int longestSubarray(int[] nums) {
        int max=0;
        for(int a:nums){
            max=Math.max(a,max);
        }
        int count=0;
        int ans=0;
        int prev=max;
        for(int a:nums){
            if(prev==a){
                count++;
                ans=Math.max(count,ans);
            }else{
                count=0;
            }
        }
        return ans;
    }
}