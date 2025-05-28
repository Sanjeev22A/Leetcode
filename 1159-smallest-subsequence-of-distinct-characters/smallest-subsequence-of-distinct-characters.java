class Solution {
    public String smallestSubsequence(String s) {
        boolean[] inStack=new boolean[26];
        Stack<Character> st=new Stack<>();
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
            }else if(!inStack[c-'a'] && st.peek()>c ){
                while(!st.isEmpty() && st.peek()>c && lastIndex.get(st.peek())>i){
                    char d=st.pop();
                    System.out.println(d);
                    inStack[d-'a']=false;
                }
                st.push(c);
               
                inStack[c-'a']=true;
            }else{
                st.push(c);
                inStack[c-'a']=true;
            }


            i++;
        }
        StringBuilder sb=new StringBuilder();
        for(char c:st){
            sb.append(c);
        }
        return sb.toString();
    }
}