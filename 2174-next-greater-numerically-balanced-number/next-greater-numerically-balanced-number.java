class Solution {
    int max=(int)Math.pow(10,6);
    boolean isBeautiful(int num){
        int val=num;
        int[] c=new int[10];
        while(num>0){
            int r=num%10;
            c[r]++;
            num/=10;
        }
        for(int i=0;i<c.length;i++){
            
            if(c[i]!=i){
                if(c[i]==0){
                    continue;
                }
                return false;
            }
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        for(int i=n+1;i<max;i++){
            
            if(isBeautiful(i)){
                return i;
            }
        }
  
        return 1224444;
    }
}