class Solution {
    public String compressedString(String word) {
        String comp="";
        int counter=0;
        char prev='.';
        for(char c:word.toCharArray()){
            if(counter==0){
                prev=c;
                counter++;
            }

            else if(prev==c && counter<9){
                counter++;
            }
            else{
                comp+=(""+counter+prev);
                prev=c;
                counter=1;
            }
        }
        if(counter!=0){
            comp+=(""+counter+prev);
        }
        return comp;
    }
}