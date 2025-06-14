class Solution {
    public String removeKdigits(String num, int k) {
        if(k>=num.length()){
            return "0";
        }

        Stack<Character> st=new Stack<>();
        for(char c:num.toCharArray()){
            while(!st.isEmpty() && st.peek()>c && k>0){
                k--;
                st.pop();
            }
            st.push(c);
        }
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }
        StringBuilder res=new StringBuilder();
        boolean numSeen=false;
        for(char c:st){
            if(c=='0' && !numSeen){
                continue;
            }else{
                numSeen=true;
                res.append(c);
            }
        }
        if(res.length()==0){
            return "0";
        }
        return res.toString();
    }

}