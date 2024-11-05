class Solution {
    boolean isVowel(char c){
        String ch="aeiou";
        if(ch.indexOf(c)!=-1){
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int count=0,maxCount=0;
        for(int i=0;i<k && i<s.length();i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
        maxCount=count;
        int slow=0,fast=k-1;
        while(fast<s.length()-1){
            if(isVowel(s.charAt(slow))){
                count--;
            }
            if(isVowel(s.charAt(fast+1))){
                count++;
            }
            slow++;
            fast++;
            maxCount=Math.max(count,maxCount);
        }
        return maxCount;
    }
}