class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int fullBottles=numBottles;
        int emptyBottles=0;
        int bottlesDrunk=0;
        while(true){
            if(fullBottles<numExchange && emptyBottles<numExchange){
                return bottlesDrunk+fullBottles;
            }
            fullBottles-=numExchange;
            bottlesDrunk+=numExchange;
            fullBottles+=1;
            numExchange++;
        }
        
    }
}