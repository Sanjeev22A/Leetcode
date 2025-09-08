class Solution {
    boolean isNoZero(int a){
        while(a>0){
            int rem=a%10;
            if(rem==0){
                return false;
            }
            a=a/10;
        }
        return true;
    }
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<n;i++){
            if(isNoZero(i) && isNoZero(n-i)){
                return new int[]{i,n-i};
            }
        }
        return new int[]{-1,-1};
    }
}