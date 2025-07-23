class Solution {
    List<List<Integer>> result;
    void permutate(int[] nums,List<Integer> current,boolean[] seen){
        if(current.size()==nums.length){
            result.add(new ArrayList<>(current));
        }
        int prev=-11;
        for(int i=0;i<nums.length;i++){
            if(!seen[i]){
                if(nums[i]!=prev){
                    current.add(nums[i]);
                    seen[i]=true;
                    prev=nums[i];
                    permutate(nums,current,seen);
                    seen[i]=false;
                    current.remove(current.size()-1);
                }
            }
        }

        
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        result=new ArrayList<>();
        Arrays.sort(nums);
   
        permutate(nums,new ArrayList<>(),new boolean[nums.length]);
        return result;
    }
}