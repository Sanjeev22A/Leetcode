class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freqCount=new int[101];
        int maxFreq=0;
        for(int a:nums){
            freqCount[a]++;
            maxFreq=Math.max(freqCount[a],maxFreq);
        }
        int val=0;
        for(int i=0;i<=100;i++){
            if(freqCount[i]==maxFreq){
                val+=maxFreq;
            }
        }
        return val;
    }
}