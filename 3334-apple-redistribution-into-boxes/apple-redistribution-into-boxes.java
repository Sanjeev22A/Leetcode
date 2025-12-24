import java.util.Arrays;
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total=0;
        for(int a:apple){
            total+=a;
        }
        Arrays.sort(capacity);
        int count=0;
        for(int i=capacity.length-1;i>=0;i--){
            int a=capacity[i];
            total-=a;
            count++;
            if(total<=0){
                return count;
            }
        }
        return -1;
    }
}