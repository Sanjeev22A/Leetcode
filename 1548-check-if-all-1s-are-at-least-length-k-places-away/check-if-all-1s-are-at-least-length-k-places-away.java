class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prev1Index=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                if(prev1Index==-1){
                    prev1Index=i;
                }else{
                    int apart=i-prev1Index-1;
                    if(apart<k){
                        return false;
                    }
                    prev1Index=i;
                }
            }
        }
        return true;
    }
}