class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res=new ArrayList<>();
        backTrack(new ArrayList<>(),0,candidates,0,target);
        return res;
    }
    void backTrack(List<Integer> current,int index,int[] candidates,int currentSum,int target){
        if(currentSum>target){
            return;
        }
        if(currentSum==target){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            current.add(candidates[i]);
            backTrack(new ArrayList<>(current),i,candidates,currentSum+candidates[i],target);
            current.remove(current.size()-1);
        }

    }
}