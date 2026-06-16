class Solution {
    String toString(Stack<?> st){
        return st.stream().map(s->s.toString()).collect(Collectors.joining(""));
    }
    public String processStr(String s) {
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if(c>='a' && c<='z'){
                st.push(c);
            }else if(c=='*'){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else if(c=='#'){
                String r=toString(st);
                for(char d:r.toCharArray()){
                    st.push(d);
                }
            }else if(c=='%'){
                StringBuilder sb=new StringBuilder();
                while(!st.isEmpty()){
                    sb.append(st.pop());
                }
                String r=sb.toString();
                for(char d:r.toCharArray()){
                    st.push(d);
                }
            }

        }
        return toString(st);
    }
}