class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nextSmallestIndexLeft=new int[n];
        int[] nextSmallestIndexRight=new int[n];
        nextSmallestIndexLeft[0]=-1;
        nextSmallestIndexRight[n-1]=n;
        Stack<Integer> forward=new Stack<>();
        forward.push(0);
        for(int i=1;i<heights.length;i++){
            while(!forward.isEmpty() && heights[forward.peek()]>=heights[i]){
                forward.pop();
            }
            if(forward.isEmpty()){
                nextSmallestIndexLeft[i]=-1;
            }else{
                nextSmallestIndexLeft[i]=forward.peek();
            }
            forward.push(i);
        }

        Stack<Integer> backward=new Stack<>();
        backward.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!backward.isEmpty() && heights[backward.peek()]>=heights[i]){
                backward.pop();
            }
            if(backward.isEmpty()){
                nextSmallestIndexRight[i]=n;
            }else{
                nextSmallestIndexRight[i]=backward.peek();
            }
            backward.push(i);
        }

        int ans=0;
        for(int i=0;i<n;i++){
            int left=nextSmallestIndexLeft[i];
            int right=nextSmallestIndexRight[i];
            int width=right-left-1;
            int height=heights[i];
            ans=Math.max(ans,width*height);
        }
        return ans;
    }
}