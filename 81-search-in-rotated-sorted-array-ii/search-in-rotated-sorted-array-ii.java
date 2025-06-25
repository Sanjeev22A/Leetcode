class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        int left=0,right=n-1;
        while(left<=right){
            int mid=left+(right-left)/2;

            if(nums[mid]==target){
                return true;
            }
            if(nums[mid]==nums[left]){
                left++;continue;
            }
            if(nums[left]<nums[mid]){
                if(nums[left]<=target && target<nums[mid]){
                    right--;
                }else{
                    left++;
                }
            }else{
                if(nums[mid]<target && target<=nums[right]){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return false;
    }
}