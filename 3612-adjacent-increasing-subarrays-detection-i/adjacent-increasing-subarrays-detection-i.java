class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if(k==1){
            return true;
        }
        
        for(int i=0;i<=nums.size()-2*k;i++){
            int curSize=0;
            boolean flag1=false,flag2=false;
            for(int j=i+1;j<i+k;j++){
                
                if(nums.get(j)>nums.get(j-1)){
                    curSize++;
                }else{
                    flag1=true;
                    break;
                }
            }
            if(flag1){
                continue;
            }
            for(int j=i+k+1;j<i+2*k;j++){
                if(nums.get(j)>nums.get(j-1)){
                    curSize++;
                }else{
                    flag2=true;
                    break;
                }
            }
            if(!flag1 && !flag2){
                return true;
            }
        }
        return false;
    }
}