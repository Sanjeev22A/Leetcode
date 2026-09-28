class Solution {
    public int maxDepth(String s) {
        int maxDepth=0;
        int curDepth=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                curDepth++;
                maxDepth=Math.max(curDepth,maxDepth);
            }else if(c==')'){
                curDepth--;
            }
        }
        return maxDepth;
    }
}