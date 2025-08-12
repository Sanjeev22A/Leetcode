class Solution {
    public int maxRotateFunction(int[] nums) {
        //F(K-1)=-4a+F(K)+SUM
        int sum=0;
        for(int a:nums){
            sum+=a;
        }
        int fk=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            fk+=i*nums[i];
        }
        ans=fk;
        for(int i=nums.length-1;i>=1;i--){
            fk+=(sum-nums.length*nums[i]);
            ans=Math.max(fk,ans);
        }
        return ans;
    }
}