class Solution {
    public int longestSubsequence(String s, int k) {
        int length=(int)(Math.log(k)/Math.log(2))+1;
        int sm=0;
        int cnt=0;
        int bitPos=0;
        for(int i=s.length()-1;i>=0;i--){
            char c=s.charAt(i);
            if(c=='0'){
                cnt++;
            }else{
                if(bitPos<length && sm+(1<<bitPos)<=k){
                    cnt++;
                    sm+=(1<<bitPos);
                }
            }
            bitPos++;
        }
        return cnt;
    }
}