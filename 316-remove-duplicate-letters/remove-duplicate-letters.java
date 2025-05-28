class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st=new Stack<>();
        boolean[] inStack=new boolean[26];
        Map<Character,Integer> lastIndex=new HashMap<>();
        int i=0;
        for(char c:s.toCharArray()){
            lastIndex.put(c,i);
            i++;
        }
        i=0;
        for(char c:s.toCharArray()){
            if(st.isEmpty()){
                st.push(c);
                inStack[c-'a']=true;
            }
            else if(inStack[c-'a']){
                i++;
                continue;
            }else if(st.peek()>c){
                while(!st.isEmpty() && st.peek()>c && lastIndex.get(st.peek())>i){
                    char d=st.pop();
                    inStack[d-'a']=false;
                }
                st.push(c);
                inStack[c-'a']=true;
            }
            else{
                st.push(c);
                inStack[c-'a']=true;
            }
            i++;
        }
        StringBuilder res=new StringBuilder();
        for(char c:st){
            res.append(c);
        }
        return res.toString();
    }
}