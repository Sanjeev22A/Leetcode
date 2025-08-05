class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        
        int total=fruits.length;
        for(int a:fruits){
            for(int i=0;i<baskets.length;i++){
                if(a<=baskets[i]){
                    baskets[i]=-1;
                    
                    total--;
                    break;
                }
            }
        }
        return total;

    }
}