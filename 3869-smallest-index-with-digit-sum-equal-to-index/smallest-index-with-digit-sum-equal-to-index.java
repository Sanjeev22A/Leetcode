class Solution {
    int digitSum(int a){
        int s=0;
        while(a>0){
            int rem=a%10;
            s+=rem;
            a/=10;
        }
        return s;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i==digitSum(nums[i])){
                return i;
            }
        }
        return -1;
    }
}