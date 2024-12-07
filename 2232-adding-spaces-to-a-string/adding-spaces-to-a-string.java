class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str=new StringBuilder();
        int i=0,j=0;
        for(char a:s.toCharArray()){
            if(i<spaces.length && spaces[i]==j){
                str.append(" ");
                i++;

            }
            str.append(a);
            j++;

        }
        return str.toString();
    }
}