class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product=1,zeroCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroCount++;
            }
            else{
                product*=nums[i];
            }
        }
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(zeroCount>1){
                ans[i]=0;
            }
            else if(zeroCount==1){
                if(nums[i]==0){
                    ans[i]=product;
                }
                else{
                    ans[i]=0;
                }
            }
            else{
                ans[i]=product/nums[i];
            }
        }
        return ans;
    }
}