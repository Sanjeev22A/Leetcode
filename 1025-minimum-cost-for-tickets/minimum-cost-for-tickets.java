class Solution {
    Map<Integer,Integer> costMap=new HashMap<>();
    int costCalc(int[] days,int[] cost,int loc,int costVal){
        if(loc>=days.length){
            return 0;
        }
        else if(costMap.containsKey(loc)){
            return costMap.get(loc);
        }
        else{
            int cost1=costCalc(days,cost,loc+1,costVal)+cost[0];
            
            int newLoc1=loc;
            while( newLoc1<days.length && days[loc]+7>days[newLoc1] ){
                newLoc1++;
            }
            int cost2=costCalc(days,cost,newLoc1,costVal)+cost[1];
           
            int newLoc2=loc;
            while(newLoc2<days.length && days[loc]+30>days[newLoc2]){
                newLoc2++;
            }
            int cost3=costCalc(days,cost,newLoc2,costVal)+cost[2];
            costMap.put(loc,Math.min(cost1,Math.min(cost2,cost3)));
            return costMap.get(loc);
        }
    }
    public int mincostTickets(int[] days, int[] costs) {
        return costCalc(days,costs,0,0);
    }
}