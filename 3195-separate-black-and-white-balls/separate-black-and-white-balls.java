class Solution {
    public long minimumSteps(String s) {
        int zeroCounter=0;
        long steps=0;
        int i=s.length()-1;
        while(i>=0){
            if(s.charAt(i)=='0'){
                zeroCounter++;
            }
            else if(s.charAt(i)=='1'){
                steps+=zeroCounter;
            }
            i--;
        }
        return steps; 
    }
}