class Solution {
    void rev(char[] arr,int i,int j){
        while(i<j){
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    String convert(char[] arr){
        StringBuilder sb=new StringBuilder();
        for(char c:arr){
            if(c != '(' && c != ')'){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public String reverseParentheses(String s) {
       Stack<Integer> stack=new Stack<>();
       char[] arr=s.toCharArray();
       for(int i=0;i<arr.length;i++){
            if(arr[i]=='('){
                stack.push(i);
            }else if(arr[i]==')'){
                int a=stack.pop();
                int b=i;
                rev(arr,a,b);
            }
       }

       return convert(arr);
    }
}