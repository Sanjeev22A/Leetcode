class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total=0;
        int rem=0;
        while(true){
            total+=numBottles;
            int empty=numBottles;
            numBottles=(empty+rem)/numExchange;
            rem=(empty+rem)%numExchange;
            //System.out.println(numBottles+":"+rem);
            if(numBottles<=0){
                total+=numBottles;
                break;
            }
        }
        return total;
    }
}