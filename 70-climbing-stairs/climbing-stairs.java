class Solution {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        int stp0=0,stp1=1,stp2=2;
        for(int i=3;i<=n;i++){
            stp0=stp1+stp2;
            stp1=stp2;
            stp2=stp0;
        }
        return stp2;
    }
}