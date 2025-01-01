class Solution {
    public int minFlips(int a, int b, int c) {
        int count=0;
        while(c>0 || b>0 || a>0){
            int val=c%2;
            if(val==1){
                if(a%2==0 && b%2==0){
                    count++;
                }

            }
            else{
                if(a%2==1 && b%2==1){
                    count+=2;
                }
                else if(a%2==1 || b%2==1){
                    count++;
                }
            }
            c/=2;
            b/=2;
            a/=2;
            
        }
        return count;
    }
}