class Solution {
    public String countAndSay(int n) {
        String res="1";
        for(int i=1;i<n;i++){
            res=mapToArray(res);
        }
        return res;
    }
    String mapToArray(String s){
        StringBuilder result=new StringBuilder();
        int count=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }else{
                result.append(count).append(s.charAt(i-1));
                count=1;
            }
        }
        result.append(count).append(s.charAt(s.length()-1));
        return result.toString();
    }
}