class Solution {
    public int maxBalancedShipments(int[] weight) {
        int count=0;
        int curMax=0;
        for(int i=0;i<weight.length;i++){
            if(weight[i]<curMax){
                count++;
                curMax=0;
            }else{
                curMax=Math.max(weight[i],curMax);
            }
        }
        return count;
    }
}