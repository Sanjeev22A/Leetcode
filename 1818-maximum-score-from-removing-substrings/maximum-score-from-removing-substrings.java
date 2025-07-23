class Solution {
    public int maximumGain(String s, int x, int y) {
        char prevMatch='a',curMatch='b';
        if(y>x){
            prevMatch='b';
            curMatch='a';
        }
        Stack<Character> st=new Stack<>();
        int score=0;
        for(char c:s.toCharArray()){

            if(!st.isEmpty() && st.peek()==prevMatch && c==curMatch){
                score+=Math.max(x,y);
                st.pop();
            }else{
                st.push(c);
            }
        }
        Stack<Character> st2=new Stack<>();
        for(char c:st){
            if(!st2.isEmpty() && st2.peek()==curMatch && c==prevMatch){
                score+=Math.min(x,y);
                st2.pop();
            }else{
                st2.push(c);
            }
        }
        
        return score;
    }
}