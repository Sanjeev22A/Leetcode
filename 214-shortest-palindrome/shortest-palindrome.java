class Solution {
    public String shortestPalindrome(String s) {
        String reverse=new StringBuilder(s).reverse().toString();
        String pattern=s+"#"+reverse;

        int[] lps=new int[pattern.length()];
        int i=1,k=0;
        while(i<lps.length){
            if(pattern.charAt(i)==pattern.charAt(k)){
                k++;
                lps[i]=k;
                i++;
            }
            else{
                if(k>0){
                    k=lps[k-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        String front=new StringBuilder(s.substring(lps[lps.length-1])).reverse().toString();
        return front+s;
    }
}