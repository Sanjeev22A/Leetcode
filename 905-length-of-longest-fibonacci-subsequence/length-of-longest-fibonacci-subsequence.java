class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int[][] dp=new int[arr.length][arr.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxLength=0;
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                int diff=arr[i]-arr[j];
                if(map.containsKey(diff)){
                    int index=map.get(diff);
                    if(index<j){
                        dp[i][j]=dp[j][index]+1;
                    }else{
                        dp[i][j]=2;
                    }
                }
                else{
                    dp[i][j]=2;
                }
                maxLength=Math.max(maxLength,dp[i][j]);
            }
        }
        return maxLength>2?maxLength:0;
    }
}