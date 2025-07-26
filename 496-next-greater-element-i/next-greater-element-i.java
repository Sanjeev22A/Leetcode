class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreater=new int[nums2.length];
        nextGreater[nums2.length-1]=0;
        Stack<Integer> st=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            map.put(nums2[i],i);
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nextGreater[i]=-1;
            }else{
                nextGreater[i]=st.peek();
            }
            st.push(nums2[i]);
        }
        
        int[] result=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            result[i]=nextGreater[map.get(nums1[i])];
        }
        
        return result;
    }
}