class Solution {
    public String longestPrefix(String s) {
        int[] lps=new int[s.length()];
        lps[0]=0;
        int i=1,j=0;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                lps[i]=j+1;
                i++;
                j++;
            }else{
                if(j!=0){
                    j=lps[j-1];
                }else{
                    j=0;
                    lps[i]=0;
                    i++;
                }
            }
        }
        return s.substring(0,lps[s.length()-1]);
    }
}