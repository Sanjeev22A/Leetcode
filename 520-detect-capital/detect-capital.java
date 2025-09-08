class Solution {

    public boolean detectCapitalUse(String word) {
        boolean allCapital=true,allNotCapital=true,firstLetterOnly=true;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c>='A' && c<='Z'){
                if(i!=0){
                    firstLetterOnly=false;
                }
                allNotCapital=false;
            }else{
                allCapital=false;
            }
            
        }
        return allCapital || allNotCapital || firstLetterOnly;
    }
}