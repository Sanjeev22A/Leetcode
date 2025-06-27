class Solution {
    boolean canBeFormed(int[] m1,int[] m2){
        for(int i=0;i<26;i++){
            if(m1[i]>m2[i]){
                return false;
            }
        }
        return true;
    }
    public int countCharacters(String[] words, String chars) {
        int[] countMap=new int[26];
        for(char c:chars.toCharArray()){
            countMap[c-'a']++;
        }
        int length=0;
        for(String word:words){
            int[] map2=new int[26];
            for(char c:word.toCharArray()){
                map2[c-'a']++;
            }
            if(canBeFormed(map2,countMap)){
                length+=word.length();
            }
        }
        return length;
    }
}