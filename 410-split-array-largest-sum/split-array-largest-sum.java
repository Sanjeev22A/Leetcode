class Solution {
    boolean isPossible(int[] nums,long allowed,int k){
        int curSplitCount=1;
        long runningTotal=0L;
        for(int a:nums){
            if(a>allowed){
                return false;
            }
            else if(curSplitCount>k){
                return false;
            }
            else if(runningTotal+(long)a>allowed){
                runningTotal=a;
                curSplitCount++;
            }else{
                runningTotal+=a;
            }
        }
        return curSplitCount<=k;
    }
    public int splitArray(int[] nums, int k) {
        long end=0L;
        for(int a:nums){
            end+=(long)a;
        }
        long start=0;
        int ans=0;
        while(start<=end){
            long mid=start+(end-start)/2;
           
            if(isPossible(nums,mid,k)){
                ans=(int)mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        
        return ans;
    }
}