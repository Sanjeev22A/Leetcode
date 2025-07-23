class Solution {
    public int hIndex(int[] citations) {
       int[] freqArray=new int[1001];
       for(int a:citations){
            freqArray[a]++;
       }
       int prevSeen=0;
       for(int i=1000;i>=0;i--){
        prevSeen+=freqArray[i];
        if(prevSeen>=i){
            return i;
        }
       }
       return 0;
    }
}