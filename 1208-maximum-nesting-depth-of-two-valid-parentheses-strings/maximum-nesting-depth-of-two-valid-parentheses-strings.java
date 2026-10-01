class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] nestingDepth=new int[seq.length()];
        int curDepth=0, i=0;
        for(char c:seq.toCharArray()){
            if(c=='('){
                curDepth++;
                nestingDepth[i++]=curDepth;
            }else{
                nestingDepth[i++]=curDepth;
                curDepth--;
            }
            
        }
        for(int j=0;j<nestingDepth.length;j++){
            if(nestingDepth[j]%2==1){
                nestingDepth[j]=0;
            }else{
                nestingDepth[j]=1;
            }
        }
        return nestingDepth;
    }
}