class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length==1){
            List<Integer> res=new ArrayList<>();
            res.add(nums[0]);
            return res;
        }
        Arrays.sort(nums);
        int[] dp=new int[nums.length];
        int[] prev=new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(prev,-1);
        int index=-1,max=0;
        for(int i=1;i<nums.length;i++){
            
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    prev[i]=j;
                }
                
            }
            
            if(dp[i]>max){
                
                max=dp[i];
                index=i;
            }
        }
        
        List<Integer> result=new ArrayList<>();
        while(index!=-1){
            result.add(nums[index]);
            index=prev[index];
        }
        return result;

        
    }
}