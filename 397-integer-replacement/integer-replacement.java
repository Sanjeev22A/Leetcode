class Solution {
    public int integerReplacement(int num) {
        int count=0;
        long n=(long)num;
        while(n!=1){
            if((n&1)==0){
                n=n/2;
            }
            else{
                if(n==3 || ((n>>1)&1)==0){
                    n--;
                }
                else{
                    n++;
                }
            }
            count++;
        }
        return count;
    }
}