class Solution {
    public int hIndex(int[] citations) {
        int[] freqArray=new int[1001];
        for(int citation:citations){
            freqArray[citation]++;
        }
        int hIndex;
        for(int i=999;i>=0;i--){
            freqArray[i]=freqArray[i+1]+freqArray[i];
            if(freqArray[i]>=i){
                hIndex=i;
                return hIndex;
            }
        }
        return -1;
    }
}