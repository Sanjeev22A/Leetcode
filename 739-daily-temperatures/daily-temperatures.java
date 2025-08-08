class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans=new int[temperatures.length];
        Stack<int[]> st=new Stack<>();
        for(int i=temperatures.length-1;i>=0;i--){
            if(st.isEmpty()){
                ans[i]=0;
                st.push(new int[]{temperatures[i],i});
            }else{
                while(!st.isEmpty() && temperatures[i]>=st.peek()[0]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    ans[i]=st.peek()[1]-i;
                }
                st.push(new int[]{temperatures[i],i});
            }
        }
        return ans;
    }
}