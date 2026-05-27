class Solution {

    boolean isUpper(char c){
        if(c>='A' && c<='Z'){
            return true;
        }
        return false;
    }

    int convert(char c){
        if(isUpper(c)){
            return (int)(c-'A');
        }else{
            return (int)(c-'a');
        }
    }
    public int numberOfSpecialChars(String word) {
        int[] lower=new int[26];
        int[] upper=new int[26];

        for(char c:word.toCharArray()){
            int idx=convert(c);

            if(isUpper(c)){
                upper[idx]=1;
            }else{
                if(upper[idx]==1){
                    lower[idx]=-1;
                }else{
                    lower[idx]=1;
                }
            }
            //System.out.println(idx+":"+lower[idx]+":"+upper[idx]);
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(lower[i]==1 && upper[i]==1){
                count+=1;
            }
        }
        return count;
    }
}