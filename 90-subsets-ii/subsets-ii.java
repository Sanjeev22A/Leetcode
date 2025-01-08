class Solution {
    List<List<Integer>> result;
    public void recurse(List<Integer> cur,int index,int[] nums){
        
        result.add(new ArrayList<>(cur));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1])continue;
            cur.add(nums[i]);
            recurse(cur,i+1,nums);
            cur.remove(cur.size()-1);

        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result=new ArrayList<>();
        Arrays.sort(nums);
        recurse(new ArrayList<>(),0,nums);
        return result;
    }
}