class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] nextGreater=new int[nums.length];
        Arrays.fill(nextGreater,-1);
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        for(int i=2*n-1;i>=0;i--){
            int idx=i%n;
            System.out.println();
            while(!st.isEmpty() && st.peek()<=nums[idx]){
                st.pop();
            }
            if(!st.isEmpty()){
                nextGreater[idx]=st.peek();
            }
            st.push(nums[idx]);
        }
        return nextGreater;
    }
}