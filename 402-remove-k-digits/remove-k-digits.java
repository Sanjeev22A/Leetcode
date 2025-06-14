class Solution {
    public String removeKdigits(String num, int k) {
        if(k>=num.length()){
            return "0";
        }
        Stack<Integer> st=new Stack<>();
        
        for(char c:num.toCharArray()){
            if(k>0){
                while(!st.isEmpty() && st.peek()>(c-'0') && k>0){
                    st.pop();
                    k--;
                }
                st.push(c-'0');
                
            }else{
                st.push(c-'0');
            }
        }
        StringBuilder res=new StringBuilder();
        while(k>0){
            st.pop();
            k--;
        }
        boolean numSeen=false;
        for(int a:st){
            if(a==0 && !numSeen){
                continue;
            }else{
                numSeen=true;
                res.append(a+"");
            }
        }
        if(res.toString().length()==0){
            return "0";
        }
        return res.toString();
    }
}