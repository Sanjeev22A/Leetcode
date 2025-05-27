class Solution {
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        int stp0=0,stp1=1,stp2=1;
        for(int i=3;i<=n;i++){
            int temp=stp2+stp1+stp0;
            stp0=stp1;
            stp1=stp2;
            stp2=temp;
           
        }
        return stp2;
    }
}