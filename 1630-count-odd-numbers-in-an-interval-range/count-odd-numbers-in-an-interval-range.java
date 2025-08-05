class Solution {
    public int countOdds(int low, int high) {
        if(low%2==0){
            low++;
        }
        if(high%2==0){
            high--;
        }
        if(low>high){
            return 0;
        }
        if(low==high){
            return 1;
        }
        return 2+(high-low-1)/2;
    }
}