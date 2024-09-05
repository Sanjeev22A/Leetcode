class Solution {
    int binarySearch(int[] nums,int target){
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>target){
                high=mid-1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int index=binarySearch(nums,target);
        if(index==-1){
            int[] arr={-1,-1};
            return arr;
        }
        else{
            int start=index,end=index;
            while(end<nums.length && nums[end]==target){
                end++;
            }
            end--;
            while(start>=0 && nums[start]==target){
                start--;
            }
            start++;
            int[] arr={start,end};
            return arr;
        }
    }
}