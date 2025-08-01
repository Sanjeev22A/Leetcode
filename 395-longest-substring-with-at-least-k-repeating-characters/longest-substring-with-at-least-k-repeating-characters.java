class Solution {
    boolean check(int[] count,int k){
        boolean flag=true;
        for(int i=0;i<26;i++){
            if(count[i]>0 && count[i]<k){
                return false;
            }
            
        }
        return true;
    }
    public int longestSubstring(String s, int k) {
        if(k<2){
            return s.length();
        }
        
        
        int maxLength=0;
        for(int start=0;start<s.length();start++){
            int[] count=new int[26];
            for(int end=start;end<s.length();end++){
                char c=s.charAt(end);
                count[c-'a']++;
                if(check(count,k)){
                    maxLength=Math.max(end-start+1,maxLength);
                }
            }
        }
        return maxLength;
    }
}