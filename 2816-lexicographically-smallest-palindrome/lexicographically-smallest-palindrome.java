class Solution {
    public String makeSmallestPalindrome(String s) {
        int i=0,j=s.length()-1;
        char[] arr=s.toCharArray();
        while(i<j){
            if(arr[i]!=arr[j]){
                char c=(char)Math.min(arr[i],arr[j]);
                arr[i]=c;
                arr[j]=c;

            }
            i++;
            j--;
        }
        StringBuilder res=new StringBuilder();
        for(char c:arr){
            res.append(c);
        }
        return res.toString();
    }
}