class Solution {
    public int longestValidParentheses(String s) {
        int[] arr=new int[s.length()];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            else{
                if(!stack.isEmpty()){
                    int index=stack.pop();
                    arr[index]=1;
                    arr[i]=1;
                }

            }
        }
        int count=0,maxCount=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                count=0;
            }
            else{
                count++;
                maxCount=Math.max(count,maxCount);
            }
        }
        return maxCount;
    }

}