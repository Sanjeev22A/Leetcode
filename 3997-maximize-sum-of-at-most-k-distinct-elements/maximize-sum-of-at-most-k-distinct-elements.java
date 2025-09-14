class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        int[] res=new int[k];
        int j=0;
        Arrays.sort(nums);

        Set<Integer> seen=new HashSet<>();
        for(int i=nums.length-1;i>=0 && j<k;i--){
            if(!seen.contains(nums[i])){
                seen.add(nums[i]);
                res[j]=nums[i];
                j++;
            }
        }
        int[] augement=new int[j];
        for(int l=0;l<j;l++){
            augement[l]=res[l];
        }
        return augement;
    }
}