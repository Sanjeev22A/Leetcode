class Solution {
    long rev(int val){
        long cur=0;
        while(val>0){
            cur=cur*10+(long)val%10;
            val=val/10;
        }
        if(cur>Integer.MAX_VALUE){
            return 0L;
        }
        return cur;
    }
    public int reverse(int x) {
        if(x<0){
            
            return -(int)rev(Math.abs(x));
        }
        return (int)rev(x);
    }
}