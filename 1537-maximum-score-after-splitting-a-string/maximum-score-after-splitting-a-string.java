class Solution {
    public int maxScore(String s) {
        int[] suffixSum=new int[s.length()+1];
        suffixSum[s.length()]=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                suffixSum[i]=suffixSum[i+1]+1;
            }
            else{
                suffixSum[i]=suffixSum[i+1];
            }
        }
        int countZeros=0;
        int maxCount=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='0'){
                countZeros++;
            }
            maxCount=Math.max(maxCount,countZeros+suffixSum[i+1]);
        }
        return maxCount;
    }
}