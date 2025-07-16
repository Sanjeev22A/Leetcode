class Solution {
    int recurse(List<Integer> nums,int i,int target,int[][] dp,int[] left){
        if(target==0){
            return 0;
        }
        if(i>=nums.size()){
            return -1;
        }
        if(left[i]<target){
            return -1;
        }
        if(target<0){
            return -1;
        }
        if(target==0){
            return 0;
        }
        if(dp[i][target]!=-2){
            return dp[i][target];
        }
        int skip=recurse(nums,i+1,target,dp,left);
        int take=recurse(nums,i+1,target-nums.get(i),dp,left);
        if(skip==-1 && take==-1){
            dp[i][target]=-1;
            return -1;
        }
        else if(skip==-1){
            dp[i][target]=take+1;
            
        }else if(take==-1){
            dp[i][target]=skip;
        }else{
            dp[i][target]=Math.max(skip,1+take);
        }
        
        return dp[i][target];
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp=new int[nums.size()][target+1];
        int[] left=new int[nums.size()];
        Collections.sort(nums);
        for(int i=nums.size()-1;i>=0;i--){
            left[i]=nums.get(i);
            if(i<nums.size()-1){
                left[i]+=left[i+1];
            }
        }
        for(int i=0;i<nums.size();i++){
            Arrays.fill(dp[i],-2);
        }
        return recurse(nums,0,target,dp,left);
    }
}