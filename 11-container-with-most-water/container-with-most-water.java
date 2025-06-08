class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int start=0,end=height.length-1;
        while(start<end){
            int area=(end-start)*Math.min(height[start],height[end]);
            max=Math.max(area,max);

            if(height[start]<height[end]){
                start++;
            }
            else{
                end--;
            }
        }
        return max;
    }
}