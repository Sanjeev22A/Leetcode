class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int total=0;
        for(int a:costs){
            if(a<=coins){
                coins-=a;
                total++;
            }else{
                break;
            }
        }
        return total;
    }
}