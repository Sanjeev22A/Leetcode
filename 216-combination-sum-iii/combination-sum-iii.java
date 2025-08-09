class Solution {
    List<List<Integer>> result;
    int target;
    void backTrack(List<Integer> curPattern,int k,int curSum,int curIndex){
        if(curPattern.size()==k && curSum==target){
            result.add(new ArrayList<>(curPattern));
        }
        if(curPattern.size()>k || curSum>target){
            return;
        }
        for(int i=curIndex;i<=9;i++){
            curPattern.add(i);
            backTrack(curPattern,k,curSum+i,i+1);
            curPattern.remove(curPattern.size()-1);
        }

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        result=new ArrayList<>();
        target=n;
        backTrack(new ArrayList<>(),k,0,1);
        return result;
    }
}