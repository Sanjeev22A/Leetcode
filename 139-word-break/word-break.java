class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //We use dp where dp[j] means substring from 0 to j-1 belongs to dict
        boolean[] dp=new boolean[s.length()+1]; //We need one more than length as we need substring until length
        dp[0]=true; //Empty string  in dict

        HashSet<String> dict=new HashSet<>();
        for(String a:wordDict){
            dict.add(a);
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                if(dp[j]==true //First condition substring from 0 to j-1 belongs
                && dict.contains(s.substring(j,i+1))){  //Substring from j to i belongs
                    dp[i+1]=true;
                }  
            }
        }
        return dp[s.length()];
    }
}