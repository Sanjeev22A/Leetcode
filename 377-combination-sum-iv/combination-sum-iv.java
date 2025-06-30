class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        Set<Integer> set=new HashSet<>();
        for(int a:nums){
            set.add(a);
        }
        List<Integer> lst=new ArrayList<>(set);
        Collections.sort(lst);
        
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int a:lst){
                if(a>i){
                    break;
                }
                dp[i]+=dp[i-a];
            }
            //System.out.println(i+":"+dp[i]);
        }
        return dp[target];
    }
}