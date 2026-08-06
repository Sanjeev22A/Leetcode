class Solution {
    boolean check(int n, int t){
        int num=1;
        while(n>0){
            num*=(n%10);
            n/=10;
        }
        return num%t==0;
    }
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=110;i++){
            if(check(i,t)){
                return i;
            }
        }
        return -1;
    }
}