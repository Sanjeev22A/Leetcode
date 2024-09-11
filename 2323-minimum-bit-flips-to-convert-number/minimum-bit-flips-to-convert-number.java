class Solution {
    public int minBitFlips(int start, int goal) {
        int count=0;
        int xorVal=start^goal;
        while(xorVal>0){
            count+=(xorVal&1);
            xorVal>>=1;
        }
        return count;
    }
}