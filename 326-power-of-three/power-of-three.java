class Solution {
    boolean val(int n){
        if(n==0){
            return false;
        }
        if(n==1){
            return true;
        }
        if(n%3==0){
            return val(n/3);
        }
        return false;
    }
    public boolean isPowerOfThree(int n) {
        return val(n);
    }
}