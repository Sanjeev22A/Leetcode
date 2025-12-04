class Solution {
    public int countCollisions(String directions) {
        int total=0;
        Stack<Character> st=new Stack<>();
        for(char c:directions.toCharArray()){
            if(c=='R'){
                st.push(c);
            }else if(c=='S'){
                while(!st.isEmpty() && st.peek()=='R'){
                    st.pop();
                    total++;
                }
                st.push(c);
            }else{
                while(!st.isEmpty()){
                    char d=st.peek();
                    if(d=='L'){
                        
                        break;
                    }else if(d=='S'){
                        
                        total++;
                        break;
                    }else{
                        total+=2;
                        st.pop();
                        
                        while(!st.isEmpty() && st.peek()=='R'){
                            st.pop();
                            total++;
                        }
                        st.push('S');
                        break;
                    }
                }
                
            }
        }
        return total;
    }
}