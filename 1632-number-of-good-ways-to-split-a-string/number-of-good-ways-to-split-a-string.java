class Solution {
    public int numSplits(String s) {
        int[] distinctCountForward=new int[s.length()];
        int[] distinctCountBackward=new int[s.length()];
        int[] c=new int[26];
        for(int i=0;i<s.length();i++){
            char d=s.charAt(i);
            if(c[d-'a']==0){
                distinctCountForward[i]=i>0?distinctCountForward[i-1]+1:1;
            }else{
                distinctCountForward[i]=distinctCountForward[i-1];
            }
            c[d-'a']++;
        }
        c=new int[26];
        for(int i=s.length()-1;i>=0;i--){
            char d=s.charAt(i);
            if(c[d-'a']==0){
                distinctCountBackward[i]=i<s.length()-1?distinctCountBackward[i+1]+1:1;
            }else{
                distinctCountBackward[i]=distinctCountBackward[i+1];
            }
            c[d-'a']++;
        }
        int count=0;
        for(int i=0;i<s.length()-1;i++){
            if(distinctCountForward[i]==distinctCountBackward[i+1]){
                count++;
            }
        }
        return count;
    }
}