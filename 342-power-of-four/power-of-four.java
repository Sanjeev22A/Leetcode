class Solution {
    
    public boolean isPowerOfFour(int n) {
        if(n<=0){
            return false;
        }
        if(n==1){
            return true;
        }
        int count=0,pos=-1;
        for(int i=31;i>=0;i--){
            if((n&(1<<i))>0){
                count++;
                pos=i;
            }
            if(count>1){
                return false;
            }
        }
        return pos%2==0;
        
    }
}