class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1){
            return "";
        }
        int midPlace=palindrome.length()/2;
        for(int i=0;i<palindrome.length();i++){
            if(palindrome.charAt(i)!='a' &&  !(palindrome.length()%2==1 && i==midPlace)){
                return palindrome.substring(0,i)+'a'+palindrome.substring(i+1);
            }
        }
        return palindrome.substring(0,palindrome.length()-1)+'b';
    }
}