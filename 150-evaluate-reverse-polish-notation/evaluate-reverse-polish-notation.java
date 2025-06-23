class Solution {
    boolean isOp(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return true;
        }
        return false;
    }
    public int evalRPN(String[] tokens) {
        Stack<String> st=new Stack<>();
        for(String a:tokens){
            if(isOp(a)){
                int op2=Integer.parseInt(st.pop());
                int op1=Integer.parseInt(st.pop());
                switch(a){
                    case "+":st.push(op1+op2+"");break;
                    case "-":st.push(op1-op2+"");break;
                    case "*":st.push(op1*op2+"");break;
                    case "/":st.push(op1/op2+"");break;
                    
                }

            }else{
                st.push(a);
            }
        }
        return Integer.parseInt(st.pop());
    }
}