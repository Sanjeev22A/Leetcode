class Solution {
    int idx(char c){
        return (int)(c-'a');
    }
    char getChar(int idx){
        return (char)(idx+'a');
    }
    int place(int j,char[] arr,char c,int count){
        int end=arr.length-j-1;
        for(int i=0;i<count;i++){
            arr[j]=c;
            arr[end]=c;
            j++;
            end--;
        }
        return j;
    }   
    public String smallestPalindrome(String s) {
        int[] count=new int[26];
        for(char c:s.toCharArray()){
            count[idx(c)]++;
        }
        char[] arr=new char[s.length()];
        int j=0;
        for(int i=0;i<26;i++){
            int getPlacement=count[i]/2;
            count[i]-=getPlacement*2;
            j=place(j,arr,getChar(i),getPlacement);
        }

        for(int i=0;i<26;i++){
            if(count[i]==1){
                arr[j++]=getChar(i);
            }
        }

        return new String(arr);
    }
}