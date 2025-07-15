class Solution {
    boolean isAlNum(char c){
        if(c>='0' && c<='9'){
            return true;
        }
        return isAlpha(c);
       
    }
    boolean isAlpha(char c){
        if(c>='a' && c<='z'){
            return true;
        }
        if(c>='A' && c<='Z'){
            return true;
        }
        return false;
    }
    boolean isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
            return true;
        }
        if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
            return true;
        }
        return false;
    }
    boolean isConsonant(char c){
        return isAlpha(c) && !isVowel(c);
    }
    public boolean isValid(String word) {
        if(word.length()<3){
            return false;
        }
        boolean isAlNum=true,vowel=false,consonant=false;
        for(char c:word.toCharArray()){
            if(isVowel(c)){
                vowel=true;
            }
            if(isConsonant(c)){
                consonant=true;

            }
            if(!isAlNum(c)){
                //System.out.println("c1");
                return false;
            }
        }
        //System.out.println(isAlNum+":"+vowel+":"+consonant);
        return isAlNum && vowel && consonant;
    }

}