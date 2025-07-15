class Solution {
    boolean isAlpha(char c){
        if(c>='a' && c<='z'){
            return true;
        }
        return false;
    }
    public String processStr(String s) {
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if(isAlpha(c)){
                st.push(c);
            }else if(c=='*'){
                if(st.isEmpty()){
                    continue;
                }
                st.pop();
            }
            else if(c=='#'){
                if(st.isEmpty()){
                    continue;
                }
                int temp=st.size();
                for(int i=0;i<temp;i++){
                    st.push(st.get(i));
                }
            }else if(c=='%'){
                if(st.isEmpty()){
                    continue;
                }
                Stack<Character> temp=new Stack<>();
                while(!st.isEmpty()){
                    temp.push(st.pop());
                }
                for(char d:temp){
                    st.push(d);
                }
            }
           // System.out.println(st);
        }
        StringBuilder temp=new StringBuilder();
        for(char c:st){
            temp.append(c);

        }
        return temp.toString();
    }
}