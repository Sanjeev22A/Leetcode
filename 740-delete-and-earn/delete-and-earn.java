class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> map=new LinkedHashMap<>();
        List<Integer> counter=new ArrayList<>();
        for(int a:nums){
            if(!map.containsKey(a)){
                counter.add(a);
            }
            map.put(a,map.getOrDefault(a,0)+a);
        }
        int n=counter.size();
        int[][] dp=new int[counter.size()][2];  //dp[i][0] is including the cur, 
                                                //dp[i][1] is without including cur
        dp[0][0]=map.get(counter.get(0));
        dp[0][1]=0;
        for(int i=1;i<n;i++){
            int cur=counter.get(i);
            int prev=counter.get(i-1);
            if(prev<cur-1){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1])+map.get(cur);
                
            }else{
                dp[i][0]=dp[i-1][1]+map.get(cur);
            }
            dp[i][1]=Math.max(dp[i-1][0],dp[i-1][1]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);

        

    }
}