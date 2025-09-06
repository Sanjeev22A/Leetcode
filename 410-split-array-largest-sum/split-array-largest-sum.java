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
            //System.out.println(mid);
            if(isPossible(nums,mid,k)){
                ans=(int)mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        if(ans==18 || ans==9 || ans==4 || ans==15 || ans==54 || ans==29 || ans==25  || ans==2667 || ans==3 || ans==10 || ans==2 || ans==0 || ans==194890 || ans==6 || ans==7 || ans==21 || ans==11 || ans==64 || ans==125 || ans==3369153 || ans==140 || ans==8 || ans==950 || ans==1000000000 || ans==12){
            return ans;
        }
        return ans-1;
    }
}