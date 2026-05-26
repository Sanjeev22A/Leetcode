class Solution {
    boolean isUpper(char c){
        if(c>='A' && c<='Z'){
            return true;
        }
        return false;
    }
    char getAnother(boolean flag,char c){
        int add=-32;
        if(flag){
            add=32;
        }
        return (char)(c+add);
    }
    int checkIfPresent(boolean flag,char c,Set<Character> s1,Set<Character> s2){
        if(s1.contains(c)){
            return 0;
        }
        s1.add(c);
        char d=getAnother(flag,c);
        return s2.contains(d)?1:0;
    }
    public int numberOfSpecialChars(String word) {
        Set<Character> lower=new HashSet<>();
        Set<Character> upper=new HashSet<>();
        int count=0;
        for(char c:word.toCharArray()){
            boolean flag=isUpper(c);
            if(flag){
                count+=checkIfPresent(flag,c,upper,lower);
            }else{
                count+=checkIfPresent(flag,c,lower,upper);
            }
        }
        return count;
    }
}