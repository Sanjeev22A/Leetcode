class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()<k){return false;}
        if(s.length()==k){return true;}
        int[] freq=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        int odd=0,even=0;
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                if(freq[i]%2==0){even++;}
                else{
                    odd++;
                }
            }
        }
        if(odd>k){return false;}
        return true;
    }
}