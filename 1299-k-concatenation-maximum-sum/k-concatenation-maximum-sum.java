class Solution {
    int mod=(int)Math.pow(10,9)+7;
    public int kConcatenationMaxSum(int[] arr, int k) {
        int n=arr.length;
        long maxEnding=0;
        long ans=0;
        int max=Integer.MIN_VALUE;
        long totalSum=0L;
        int limit=k>2?2*n:k*n;
        for(int i=0;i<limit;i++){

            maxEnding=Math.max(maxEnding+arr[i%n],(long)arr[i%n]);
            ans=Math.max(ans,maxEnding);
            max=Math.max(arr[i%n],max);
            totalSum+=(long)arr[i%n];
        }
        totalSum=(totalSum)/(limit/n);
        if(max<0){
            return 0;
        }
        if(k>2 && totalSum>0){
            return (int)(ans+((k-2)*totalSum)%mod)%mod;
        }
        return (int)ans%mod;
    }
}