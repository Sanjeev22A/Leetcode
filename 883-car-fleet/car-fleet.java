class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] myArr=new int[position.length][2];
        for(int i=0;i<position.length;i++){
            myArr[i][0]=position[i];
            myArr[i][1]=speed[i];
        }
        Arrays.sort(myArr,(a,b)->(b[0]-a[0]));
        double[] timing=new double[position.length];
        for(int i=0;i<position.length;i++){
            if(position[i]>target){
                timing[i]=Double.MAX_VALUE;
            }else{
                timing[i]=(double)(target-myArr[i][0])/myArr[i][1];
            }
        }
        int count=0;
        double maxTime=Double.MIN_VALUE;
        for(int i=0;i<timing.length;i++){
            if(timing[i]==Double.MAX_VALUE){
                continue;
            }else{
                if(timing[i]>maxTime){
                    count++;
                    maxTime=timing[i];
                }
            }
        }
        return count;
    }
}