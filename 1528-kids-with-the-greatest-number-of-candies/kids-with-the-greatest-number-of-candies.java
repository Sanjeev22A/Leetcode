class Solution {
    int getMax(int[] candies){
        int max=candies[0];
        for(int a:candies){
            if(a>max){
                max=a;
            }
        }
        return max;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result=new ArrayList<>();
        int max=getMax(candies);
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=max){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }
        return result;
    }
}