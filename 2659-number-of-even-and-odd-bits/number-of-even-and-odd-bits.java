class Solution {
    public int[] evenOddBit(int n) {
        int[] arr=new int[2];
        int count=0;
        while(n>0){
            if((n&1)==1){
                arr[count%2]++;
            }
            count=count+1;
            n=n/2;
        }

        return arr;
    }
}