class Solution {
    int[] lps;

    public String longestPrefix(String s) {
        lps=new int[s.length()];
        int n=s.length();
        int i=1,j=0;
        while(i<n){
            if(s.charAt(i)==s.charAt(j)){
                lps[i]=j+1;
                i++;
                j++;
            }else{
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return s.substring(0,lps[n-1]);
    }
}