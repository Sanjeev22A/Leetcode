class Solution {
    public int totalMoney(int n) {
        //1+2+3+4+5+6+7=28
        //2+3+4+5+6+7+8=35
        int total=0;
        int levels=n/7;
        int base=28;
        for(int i=0;i<levels;i++){
            total+=(base+i*7);
        }
        int rem=n%7;
        levels++;
        for(int i=1;i<=rem;i++){
            total+=levels;
            levels++;
        }
        return total;
    }
}