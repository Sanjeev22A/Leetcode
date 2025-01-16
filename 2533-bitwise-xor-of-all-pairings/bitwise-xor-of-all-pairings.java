class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        if(nums1.length%2==0 && nums2.length%2==0){return 0;}
        else if(nums1.length%2==0){
            int val=0;
            for(int a:nums1){
                val=val^a;
            }
            return val;
        }
        else if(nums2.length%2==0){
            int val=0;
            for(int a:nums2){
                val=val^a;
            }
            return val;
        }
        else{
            int val=0;
            for(int a:nums1){
                val=val^a;
            }
            for(int a:nums2){
                val=val^a;
            }
            return val;
        }
    }
}