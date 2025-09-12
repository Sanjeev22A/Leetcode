class Solution {
    boolean isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
            return true;
        }
        return false;
    }
    boolean oddVowelCount(String s){
        int count=0;
        for(char c:s.toCharArray()){
            if(isVowel(c)){
                count++;
            }
        }
        return count%2==1;
    }
    boolean noVowel(String s){
        for(char c:s.toCharArray()){
            if(isVowel(c)){
                return false;
            }
        }
        return true;
    }
    int lastVowelIndex(String s){
        for(int i=s.length()-1;i>=0;i--){
            if(isVowel(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }
    boolean recurse(String s,int turn){
        //Turn=0 means Alice, Turn=1 means bob
        boolean noVowel=noVowel(s);
        boolean oddVowel=oddVowelCount(s);
        if(turn==0 && oddVowel){
            return true;
        }
        if(turn==1 && !oddVowel){
            return false;
        }
        if(turn==0 && !oddVowel){
            if(noVowel){
                return false;
            }
            return !recurse(s.substring(lastVowelIndex(s)),1);
        }
        if(turn==1 && oddVowel){
            return !recurse(s.substring(lastVowelIndex(s)),0);
        }
        return false;
    }
    public boolean doesAliceWin(String s) {
        return recurse(s,0);
    }
}