class Solution {
    public int trap(int[] height) {
        
        int[] leftHeight=new int[height.length];
        leftHeight[0]=Integer.MIN_VALUE;
        int[] rightHeight=new int[height.length];
        for(int i=1;i<height.length;i++){
            leftHeight[i]=Math.max(leftHeight[i-1],height[i-1]);
        }
        rightHeight[height.length-1]=Integer.MIN_VALUE;
        for(int i=height.length-2;i>=0;i--){
            rightHeight[i]=Math.max(rightHeight[i+1],height[i+1]);
        }
        int total=0;
        for(int i=0;i<height.length;i++){
            int l=leftHeight[i],r=rightHeight[i];
            if(l<height[i] || r<height[i]){
                continue;
            }
            total+=Math.min(l,r)-height[i];
        }
        return total;
    }
}