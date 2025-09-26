class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int[] numZeros=new int[nums.length+1];
        int[] numOnes=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            numZeros[i+1]+=numZeros[i];
            numOnes[i+1]+=numOnes[i];
            if(nums[i]==0){
                numZeros[i+1]++;
            }
            else{
                numOnes[i+1]++;
            }
        }
        int maxDivScore=0;
        int[] divScore=new int[nums.length+1];
        for(int i=0;i<nums.length+1;i++){
            int curDivScore=numZeros[i]+numOnes[nums.length]-numOnes[i];
            maxDivScore=Math.max(maxDivScore,curDivScore);
            divScore[i]=curDivScore;
        }
        List<Integer> res=new ArrayList<>();
        
        for(int i=0;i<divScore.length;i++){
            if(divScore[i]==maxDivScore){
                res.add(i);
            }
        }
        return res;
        
    }
}