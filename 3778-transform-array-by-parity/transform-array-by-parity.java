class Solution {
    public int[] transformArray(int[] nums) {
        int[] res=new int[nums.length];
        int oddCount=0;
        for(int i=0;i<nums.length;i++){
            oddCount+=(nums[i]%2);
        }
        for(int i=nums.length-1;i>=nums.length-oddCount;i--){
            res[i]=1;
        }
        return res;
    }
}