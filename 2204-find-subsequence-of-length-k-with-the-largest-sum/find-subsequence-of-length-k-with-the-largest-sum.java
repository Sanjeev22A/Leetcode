class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n=nums.length;
        int[][] val=new int[n][2];
        for(int i=0;i<n;i++){
            val[i][0]=nums[i];
            val[i][1]=i;
        }
        Arrays.sort(val,(a,b)->(b[0]-a[0]));
        int[][] res=new int[k][2];
        for(int i=0;i<k;i++){
            res[i][0]=val[i][0];
            res[i][1]=val[i][1];
        }
        Arrays.sort(res,(a,b)->(a[1]-b[1]));
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=res[i][0];
        }
        return ans;
    }
}