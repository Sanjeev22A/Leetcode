class Solution {
    int findGreaterOrEqualIndex(int[] nums,int target){
        int start=0,end=nums.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]>=target){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }

        }
        return ans;
    }
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int x=0;x<nums.length+1;x++){
            int index=findGreaterOrEqualIndex(nums,x);
            //System.out.println(index);
            if(index==-1){
                continue;
            }else{
                int length=nums.length-index;
                if(x==length){
                    return x;
                }
            }
        }
        return -1;
    }
}