class Solution {
    boolean recurse(int i,int[] bits){
        if(i==bits.length-1){
            return true;
        }
        if(i>=bits.length){
            return false;
        }
        if(bits[i]==1){
            return recurse(i+2,bits);
        }else{
            return recurse(i+1,bits);
        }
    }
    public boolean isOneBitCharacter(int[] bits) {
        return recurse(0,bits);
    }
}