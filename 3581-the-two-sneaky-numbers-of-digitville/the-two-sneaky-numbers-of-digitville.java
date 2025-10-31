class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] a=new int[101];
        int[] ans=new int[2];
        int c=0;
        for(int b:nums){
            a[b]++;
            if(a[b]==2){
                ans[c]=b;
                c++;
            }
        }
        return ans;
    }
}