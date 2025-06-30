class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        TreeSet<Integer> set=new TreeSet<>();
        for(int a:nums){
            set.add(a);
        }
        dp[0]=1;
        if(set.contains(1)){
            dp[1]=dp[0];
        }
        System.out.println(dp[1]);
        for(int i=2;i<=target;i++){
            for(int a:set){
                if(a<=i){
                    dp[i]+=dp[i-a];
                }
            }
        }
        return dp[target];

    }
}