class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        int[] dp=new int[nums.length];
        int[] count=new int[nums.length];
        Arrays.fill(count,1);
        Arrays.fill(dp,1);
        int max=0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[i]==dp[j]+1){
                        count[i]+=count[j];
                    }
                    else if(dp[j]>=dp[i]){
                        count[i]=count[j];
                        dp[i]=dp[j]+1;
                    }
                    
                }
                max=Math.max(dp[i],max);
            }
        }
        int ans=0;
        //System.out.println(max);
        for(int i=0;i<dp.length;i++){
            
            if(dp[i]==max){
                
                ans+=count[i];
            }
        }
        return ans;

    }
}