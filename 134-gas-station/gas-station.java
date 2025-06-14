class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasTotal=Arrays.stream(gas).sum();
        int costTotal=Arrays.stream(cost).sum();
        if(gasTotal<costTotal){
            return -1;
        }
        else{
            int start=0;
            int currentLeft=0;
            int n=gas.length;
            int i=0;
            while(i<n){
                if(currentLeft<0){
                    start=i;
                    currentLeft=gas[i]-cost[i];
                }else{
                    currentLeft+=(gas[i]-cost[i]);
                }
                i++;
            }
            return start;
        }
    }
}