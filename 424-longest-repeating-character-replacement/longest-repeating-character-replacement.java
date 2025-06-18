class Solution {
    public int characterReplacement(String s, int k) {
        int[] count=new int[26];
        int ans=0,start=0,end=0;
        int maxcount=0;
        while(end<s.length()){
            char cur=s.charAt(end);
            count[cur-'A']++;
            maxcount=Math.max(maxcount,count[cur-'A']);
            while((end-start+1)-maxcount>k){
                count[s.charAt(start)-'A']--;
                start++;
            }
            ans=Math.max(end-start+1,ans);
            end++;
        }
        return ans;
    }
}