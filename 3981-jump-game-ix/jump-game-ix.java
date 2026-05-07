class Solution {
    public int[] maxValue(int[] nums) {
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int b=i>0?ans[i-1]:0;
            ans[i]=Math.max(b,nums[i]);
        }

        Stack<Integer> st=new Stack<>();
        st.push(nums.length-1);
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=ans[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i]=Math.max(ans[i],ans[st.peek()]);
            }
            st.push(i);
        }
        return ans;

    }
}