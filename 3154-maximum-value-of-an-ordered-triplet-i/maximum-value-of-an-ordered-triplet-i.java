class Solution {
    public long maximumTripletValue(int[] nums) {
        long val=Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    long mid=(long)(nums[i]-nums[j])*nums[k];
                    val=Math.max(mid,val);
                }
            }
        }
        if(val<0){
            val=0;
        }
        return val;
    }
}