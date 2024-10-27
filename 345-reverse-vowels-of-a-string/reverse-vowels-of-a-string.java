class Solution {
    boolean isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
            return true;
        }
        if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
            return true;
        }
        return false;
    }
    public String reverseVowels(String s) {
        int i=0,j=s.length()-1;
        char[] c=s.toCharArray();
        while(i<j){
            if(!isVowel(c[i])){
                i++;
            }
            else if(!isVowel(c[j])){
                j--;
            }
            else{
                char temp=c[i];
                c[i]=c[j];
                c[j]=temp;
                i++;
                j--;
            }
        }
        s="";
        for(char d:c){
            s+=d;
        }
        return s;
    }
}