class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] basketUsed=new boolean[baskets.length];
        int total=fruits.length;
        for(int a:fruits){
            for(int i=0;i<baskets.length;i++){
                if(a<=baskets[i] && !basketUsed[i]){
                    basketUsed[i]=true;
                    
                    total--;
                    break;
                }
            }
        }
        return total;

    }
}