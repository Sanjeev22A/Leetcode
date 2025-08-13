class Solution {
    
    int sum(int[] a){
        int sum=0;
        for(int n:a){
            sum+=n;
        }
        return sum;
    }
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int sum1=sum(nums1);
        int sum2=sum(nums2);
       
        if(sum1<sum2){
            int[] temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int[] diffArray=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            diffArray[i]=nums2[i]-nums1[i];
        }
        
        int maxSum=0;
        int curSum=0;
        for(int i=0;i<nums1.length;i++){
            curSum=Math.max(diffArray[i],curSum+diffArray[i]);
            maxSum=Math.max(maxSum,curSum);
        }
        
        for(int i=0;i<nums1.length;i++){
            diffArray[i]=nums1[i]-nums2[i];
        }
        int s1=sum(nums1)+maxSum;
        maxSum=0;curSum=0;
        for(int i=0;i<nums1.length;i++){
            curSum=Math.max(diffArray[i],curSum+diffArray[i]);
            maxSum=Math.max(maxSum,curSum);

        }
        int s2=sum(nums2)+maxSum;
        return Math.max(s1,s2);
    }
}