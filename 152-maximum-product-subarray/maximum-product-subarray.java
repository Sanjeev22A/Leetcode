class Solution {
    public int maxProduct(int[] nums) {
        //Maximum product sub array ending at this index
        int[] productSubArrayMax=new int[nums.length];
        int[] productSubArrayMin=new int[nums.length];
        productSubArrayMax[0]=nums[0];
        productSubArrayMin[0]=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            productSubArrayMax[i]=Math.max(productSubArrayMax[i-1]*nums[i],nums[i]);
            productSubArrayMax[i]=Math.max(productSubArrayMin[i-1]*nums[i],productSubArrayMax[i]);

            productSubArrayMin[i]=Math.min(productSubArrayMin[i-1]*nums[i],nums[i]);
            productSubArrayMin[i]=Math.min(productSubArrayMax[i-1]*nums[i],productSubArrayMin[i]);
            ans=Math.max(productSubArrayMax[i],ans);
        }
        return ans;
        
    }
}