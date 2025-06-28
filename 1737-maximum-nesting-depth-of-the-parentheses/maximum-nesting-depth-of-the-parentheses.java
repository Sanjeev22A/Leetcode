class Solution {
    public int maxDepth(String s) {
        int depth=0;
        int maxDepth=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                depth++;
                maxDepth=Math.max(depth,maxDepth);
            }else if(c==')'){
                depth--;
            }
        }
        return maxDepth;
    }
}