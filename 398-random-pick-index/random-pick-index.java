class Solution {
    int[] nums;
    public Solution(int[] nums) {
        this.nums=nums;
    }
    
    public int pick(int target) {
        List<Integer> targetSet=new ArrayList<>();
        Random rand=new Random();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                targetSet.add(i);
            }
        }
        return targetSet.get(rand.nextInt(targetSet.size()));

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */