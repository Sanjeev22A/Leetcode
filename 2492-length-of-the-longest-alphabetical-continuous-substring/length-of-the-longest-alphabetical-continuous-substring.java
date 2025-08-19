class Solution {
    public int longestContinuousSubstring(String s) {
        int cur=0,max=0;
        char prev='.';
        for(char c:s.toCharArray()){
            if(prev+1==c){
                cur++;
            }else{
                cur=1;
            }
            prev=c;
            max=Math.max(cur,max);
        }
        return max;
    }
}