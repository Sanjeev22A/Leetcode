class Solution {
    int MOD=(int)Math.pow(10,9)+7;
    int[] makeArray(int n){
        List<Integer> arr=new ArrayList<>();
        for(int i=31;i>=0;i--){
            if((n&(1<<i))>0){
                arr.add(1<<i);
            }
        }
        int[] ans=new int[arr.size()];
        int j=0;
        for(int i=arr.size()-1;i>=0;i--){
            ans[j++]=arr.get(i);
        }
        return ans;
    }
    long modPow(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1)           
                result = (result * base) % mod;
            base = (base * base) % mod;   
            exp >>= 1;                   
        }
        return result;
    }

    public int[] productQueries(int n, int[][] queries) {
        int[] arr=makeArray(n);
        long[] powers=new long[arr.length+1];
        powers[0]=1;
        for(int i=0;i<arr.length;i++){
            powers[i+1]=(powers[i]*(long)arr[i])%MOD;
            //System.out.println(arr[i]);
        }
        int[] ans=new int[queries.length];
        int i=0;
        for(int[] a:queries){
            long num=powers[a[1]+1];
            long denom=modPow(powers[a[0]],MOD-2,MOD);
            ans[i++]=(int)((num*denom)%MOD);
        }
        return ans;
    }
}