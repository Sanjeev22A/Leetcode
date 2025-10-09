class Solution {
    public long minTime(int[] skill, int[] mana) {
        long[] earlyCompleteTime=new long[skill.length];
        long minTime=0L;

        for(int i=0;i<mana.length;i++){

            long prevTime=0L;
            for(int j=0;j<skill.length;j++){
                long startTime=Math.max(earlyCompleteTime[j],prevTime);
                prevTime=startTime+(long)skill[j]*mana[i];
                earlyCompleteTime[j]=prevTime;
                //System.out.print(prevTime+":");
            }
            //Backward pass to adjust
            for(int j=skill.length-2;j>=0;j--){
                earlyCompleteTime[j]=earlyCompleteTime[j+1]-(long)skill[j+1]*mana[i];
            }
            //System.out.println();
            minTime=earlyCompleteTime[skill.length-1];
        }
        return minTime;

    }
}