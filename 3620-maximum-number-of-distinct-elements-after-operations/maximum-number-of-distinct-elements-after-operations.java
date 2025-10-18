class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        //Set<Integer> t=new HashSet<>();
        Set<Integer> seen=new HashSet<>();
        int temp=-k;
        for(int i=0;i<nums.length;i++){
            int lower=nums[i]-k;
            //t.add(nums[i]);
            if(i>0){
                lower=Math.max(lower,nums[i-1]+1);
            }
            if(Math.abs(nums[i]-lower)>k){
                nums[i]=nums[i-1];
            }else{
                nums[i]=lower;
                seen.add(nums[i]);
            }
            //System.out.println(nums[i]);
            
        }
        
            
        return seen.size();

    }
}