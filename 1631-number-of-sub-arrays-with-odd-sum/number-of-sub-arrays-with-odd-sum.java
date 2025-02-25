class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD=(int)Math.pow(10,9)+7;
        int[] dpOdd=new int[arr.length];
        int[] dpEven=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            arr[i]%=2;
        }
        int n=arr.length-1;
        if(arr[n]==1){
            dpOdd[n]=1;
            dpEven[n]=0;

        }else{
            dpOdd[n]=0;dpEven[n]=1;
        }

        for(int i=n-1;i>=0;i--){
            if(arr[i]==1){
                dpOdd[i]=(dpEven[i+1]+1)%MOD;
                dpEven[i]=(dpOdd[i+1]);
            }
            else{
                dpEven[i]=(1+dpEven[i+1])%MOD;
                dpOdd[i]=dpOdd[i+1];
            }
        }
        int sum=0;
        for(int a:dpOdd){
            sum=(sum+a)%MOD;
        }
        return sum;
    }
}