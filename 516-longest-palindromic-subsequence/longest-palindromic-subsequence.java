class Solution {
    String s;
    Map<Long,Integer> memo;
    int dp(int startIndex,int endIndex){
        if(startIndex>endIndex){
            return 0;
        }
        else if(startIndex==endIndex){
            return 1;
        }
        Long key=((long)startIndex<<32)|endIndex;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(s.charAt(startIndex)==s.charAt(endIndex)){
            int val=2+dp(startIndex+1,endIndex-1);
            memo.put(key,val);
            return val;

        }else{
            int val= Math.max(dp(startIndex+1,endIndex),dp(startIndex,endIndex-1));
            memo.put(key,val);
            return val;
        }
    }
    public int longestPalindromeSubseq(String s) {
        memo=new HashMap<>();
        int n=s.length();   
        this.s=s;
        
       
       return dp(0,n-1);
       
        
    }

}