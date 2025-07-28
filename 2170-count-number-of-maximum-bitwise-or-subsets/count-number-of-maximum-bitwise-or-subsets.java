class Solution {
    
    
    public int countMaxOrSubsets(int[] nums) {
        int maxOr=0;
        for(int a:nums){
            maxOr|=a;
        }
        int n=nums.length;
        int limit=(int)Math.pow(2,n);
        int count=0;
        for(int i=0;i<limit;i++){
            int curOr=0;
            for(int j=n-1;j>=0;j--){
                if((i&(1<<j))>0){
                    curOr|=nums[j];
                }
            }
            if(curOr==maxOr){
                count++;
            }
        }
        return count;

    }
}