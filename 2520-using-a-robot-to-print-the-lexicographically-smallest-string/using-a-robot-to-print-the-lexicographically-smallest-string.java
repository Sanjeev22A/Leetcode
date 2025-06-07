class Solution {
    public String robotWithString(String s) {
        int[] map=new int[26];
        char smallest='z'+1;
        for(char c:s.toCharArray()){
            map[c-'a']++;
            if(c<smallest){
                smallest=c;
            }
        }
        Stack<Character> t=new Stack<>();
        StringBuilder res=new StringBuilder();
        for(char c:s.toCharArray()){
            map[c-'a']--;
          
            t.push(c);
            while(smallest!='z' && map[smallest-'a']==0){
                smallest++;
            }
            
            while(!t.isEmpty () && t.peek()<=smallest){
                res.append(t.pop());
            }
        }
        
        while(!t.isEmpty()){
            res.append(t.pop());
        }
        return res.toString();
    }
}