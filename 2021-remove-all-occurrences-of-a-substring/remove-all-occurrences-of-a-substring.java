class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            stack.push(c);
            if(stack.size()>=part.length() && isMatch(stack,part,part.length())){
                for(int i=0;i<part.length();i++){
                    stack.pop();
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<stack.size();i++){
            sb.append(stack.get(i));

        }
        return sb.toString();
    }
    boolean isMatch(Stack<Character> stack,String str,int length){
        int j=stack.size()-1;
        for(int i=length-1;i>=0;i--,j--){
            if(stack.get(j)!=str.charAt(i)){
                return false;
            }
        }
        return true;
    }
}