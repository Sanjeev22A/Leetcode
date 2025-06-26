class Solution {
    public int longestSubsequence(String s, int k) {
        int cnt=0;
        int sm=0;
        int length=(int)(Math.log(k)/Math.log(2))+1;

        for(int i=s.length()-1;i>=0;i--){
            char c=s.charAt(i);
            if(c=='0'){
                cnt++;
            }else{
                if(cnt<length && sm+(1<<cnt)<=k){
                    sm+=(1<<cnt);
                    cnt++;
                }
            }
        }
        return cnt;
        
    }
}