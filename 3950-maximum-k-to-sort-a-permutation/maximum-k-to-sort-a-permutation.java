class Solution {
    public int sortPermutation(int[] nums) {
        int val=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i]){
                val=(val&i);
            }
        }
        if(val==Integer.MAX_VALUE){
            return 0;
        }
        return val;
    }
}