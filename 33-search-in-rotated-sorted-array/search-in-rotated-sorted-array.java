class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int left=0,right=n-1;

        while(left<=right){
            int mid=left+(right-left)/2;

            if(nums[mid]==target){
                return mid;
            }else{
                //Left half is assumed to be sorted
                if(nums[left]<=nums[mid]){
                    if(nums[left]<=target && target<nums[mid]){
                        right=mid-1;
                    }else{
                        left=mid+1;
                    }

                }//Right half assumed to be sorted
                else{
                    if(nums[mid]<=target && target<=nums[right]){
                        left=mid+1;
                    }else{
                        right=mid-1;
                    }
                }
            }
        }
        return -1;
    }
}