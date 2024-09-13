class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefixSum=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(i==0){
                prefixSum[i]=arr[i];
            }
            else{
                prefixSum[i]=prefixSum[i-1]^arr[i];
            }
        }
        int[] ans=new int[queries.length];
        int i=0;
        for(int[] query:queries){
            int left=query[0];
            int right=query[1];
            if(left==0){
                ans[i++]=prefixSum[right];
            }
            else{
                ans[i++]=(prefixSum[right]^prefixSum[left-1]);
            }
        }
        return ans;
    }
}