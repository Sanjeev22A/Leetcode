class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int i=1;i<=60;i++){
            long cur=(long)num1-(long)num2*i;
            if(cur<i){
                return -1;

            }
            if(i>=Long.bitCount(cur)){
                return i;
            }
        }
        return -1;
    }
}