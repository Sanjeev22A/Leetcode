class Solution {
    public String makeFancyString(String s) {
        StringBuilder result=new StringBuilder();
        int i=-1;
        for(char c:s.toCharArray()){
            if(result.length()>=2){
                if(c==result.charAt(i-1) && result.charAt(i)==c){
                    continue;
                }
            }
            result.append(c);
            i++;
        }
        return result.toString();
    }
}