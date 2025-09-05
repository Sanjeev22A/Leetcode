class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int i=1;i<=60;i++){
            long cur=(long)num1-(long)num2*i; //i operations done
            //If number is less than i we cant represent it in terms of power of i, if greater means we can liberally use 0s as much as needed and pad
            if(cur<(long)i){
                return -1;
            }
            if(i>=Long.bitCount(cur)){
                return i;
            }
        }
        return -1;
    }
}