class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> subsets=new ArrayList<>();
        generateSubsets(nums,new ArrayList<>(),0,subsets);
        int total=0;
        for(List<Integer> subset:subsets){
            int xorTotal=0;
            for(int a:subset){
                xorTotal^=a;
            }
            total+=xorTotal;
        }
        return total;
    }
    private void generateSubsets(int[] nums,List<Integer> subset,int index,List<List<Integer>> subsets){
        if(index>=nums.length){
            subsets.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        generateSubsets(nums,subset,index+1,subsets);
        subset.remove(subset.size()-1);
        generateSubsets(nums,subset,index+1,subsets);

    }
}