class Solution {
    int[] nums;
    void backTrack(List<List<Integer>> result,List<Integer> cur,int index){
        result.add(new ArrayList<>(cur));
        for(int i=index;i<nums.length;i++){
            cur.add(nums[i]);
            backTrack(result,cur,i+1);
            cur.remove(cur.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        this.nums=nums;
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        backTrack(result,cur,0);
        return result;
    }

}