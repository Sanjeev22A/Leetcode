class Solution {
    int[] lps;
    void lpsBuild(String needle){
        int i=1,j=0;
        while(i<needle.length()){
            if(needle.charAt(i)==needle.charAt(j)){
                lps[i]=j+1;
                j++;
                i++;
            }else{
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }
    }
    int search(String haysack,String needle){
        int i=0,j=0;
        int m=haysack.length();
        int n=needle.length();
        while(i<m){
            if(haysack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j==needle.length()){
                    
                    return i-j;
                    //j=lps[j-1];
                }
            }else{
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return -1;
    }
    public int strStr(String haystack, String needle) {
        lps=new int[needle.length()];
        lpsBuild(needle);
        return search(haystack,needle);
    }
}