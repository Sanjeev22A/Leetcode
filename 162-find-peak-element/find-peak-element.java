class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid==0 && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(mid==nums.length-1 && nums[mid-1]<nums[mid]){
                return mid;
            }
            else if(mid!=0 && mid!=nums.length-1 && nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(mid!=0 && nums[mid-1]>nums[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
}