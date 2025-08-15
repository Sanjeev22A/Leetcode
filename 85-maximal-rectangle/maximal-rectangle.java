class Solution {
    int[] nextLesserIndexLeft(int[] height){
        int[] ans=new int[height.length];
        ans[0]=-1;
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for(int i=1;i<height.length;i++){
            while(!st.isEmpty() && height[st.peek()]>=height[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;
            }else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    int[] nextLesserIndexRight(int[] height){
        int[] ans=new int[height.length];
        int n=height.length;
        ans[n-1]=n;
        Stack<Integer> st=new Stack<>();
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && height[st.peek()]>=height[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=n;
            }else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    int calcMaxRectangle(int[] height){
        int[] left=nextLesserIndexLeft(height);
        int[] right=nextLesserIndexRight(height);
        int ans=0;
        for(int i=0;i<height.length;i++){
            int h=height[i];
            int width=right[i]-left[i]-1;
            ans=Math.max(h*width,ans);
        }
        return ans;
    }
    public int maximalRectangle(char[][] matrix) {
        int[] height=new int[matrix[0].length];
        int max=0;
        for(char[] a:matrix){
            for(int i=0;i<a.length;i++){
                if(a[i]=='0'){
                    height[i]=0;
                }else{
                    height[i]+=1;
                }
            }
            int val=calcMaxRectangle(height);
            max=Math.max(max,val);
        }
        return max;
    }
}