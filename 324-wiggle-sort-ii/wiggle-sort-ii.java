class Solution {
    void rev(int[] arr,int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int leftBoundary=0;
        int rightBoundary=0;
        int n=nums.length;
        if(n%2==0){
            leftBoundary=n/2-1;
            rightBoundary=n/2;
        }else{
            leftBoundary=n/2;
            rightBoundary=n/2+1;
        }
        rev(nums,0,leftBoundary);
        rev(nums,rightBoundary,n-1);
        

        int[] res=new int[n];
        int j=0;
        for(int i=0;i<n;i+=2){
            res[i]=nums[j++];
        }
        for(int i=1;i<n;i+=2){
            res[i]=nums[j++];
        }
        for(int i=0;i<n;i++){
            nums[i]=res[i];
        }
        
        

    }
}