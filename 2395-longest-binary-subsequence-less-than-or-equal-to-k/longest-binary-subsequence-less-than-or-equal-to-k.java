class Solution {
    public int longestSubsequence(String s, int k) {
        int length=(int)(Math.log(k)/Math.log(2))+1;
        int cnt=0,sm=0;
        int bitPos=0;
        for(int i=s.length()-1;i>=0;i--){
            char c=s.charAt(i);
            if(c=='0'){
                cnt++;
            }else{
                if(cnt<length && sm+(1<<cnt)<=k){
                    System.out.println(bitPos+":"+cnt);
                    sm+=(1<<cnt);
                    cnt++;
                }
            }
            bitPos++;
        }
        return cnt;
    }
}