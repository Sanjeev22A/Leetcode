class Solution {
    public int hammingDistance(int x, int y) {
        int dif=0;
        while(true){
            if(x==0 && y==0){
                break;
            }
            if((x&1)!=(y&1)){dif++;}
                x=x>>1;
                y=y>>1;

        }
        return dif;
    }
}