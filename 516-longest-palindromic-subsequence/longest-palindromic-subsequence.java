class Solution {
    String s;
    Map<Long,Integer> memo;
    int dp(int start,int end){
        if(start>end){
            return 0;
        }
        long key=((long)start<<32)|end;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(start==end){
            memo.put(key,1);
            return 1;
        }
        if(s.charAt(start)==s.charAt(end)){
            int val=2+dp(start+1,end-1);
            memo.put(key,val);
            return val;
        }
        int v1=dp(start+1,end);
        int v2=dp(start,end-1);
        memo.put(key,Math.max(v1,v2));
        return Math.max(v1,v2);
    }
    public int longestPalindromeSubseq(String s) {
        memo=new HashMap<>();
        this.s=s;
        return dp(0,s.length()-1);
    }
}