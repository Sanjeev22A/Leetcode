class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        int maxJumbo=Math.min(tomatoSlices/4,cheeseSlices);
        for(int numJumbo=0;numJumbo<=maxJumbo;numJumbo++){
            int remTomato=tomatoSlices-numJumbo*4;
            int remCheese=cheeseSlices-numJumbo;
            if(remTomato==remCheese*2){
                List<Integer> temp=new ArrayList<>();
                temp.add(numJumbo);
                temp.add(remTomato/2);
                return temp;
            }
        }
        return new ArrayList<>();
    }
}