class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long total=0;
        for(int i=0;i<nums.length;){
            int j=i+1;
            while(j<nums.length && nums[j]!=nums[j-1]){
                j++;
            }
            
            long length=(long)j-(long)i;
            //System.out.println(j+":"+i+":"+length);
            total+=(length*(length+1))/2;
            i=j;
        }
        return total;
    }
}