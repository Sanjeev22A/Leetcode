class Solution {
    static boolean opening(char c){
        return c=='(' || c=='{' || c=='[';
    }
    static int samePair(char c){
        if(c=='(' || c==')'){
            return 1;
        }
        else if(c=='{' || c=='}'){
            return 2;
        }
        else if(c=='[' || c==']'){
            return 3;
        }
        return 0;
    }
    public boolean isValid(String s) {
      Stack<Character> paran=new Stack<Character>();  
      for(char c:s.toCharArray()){
        if(opening(c)){
            paran.push(c);
        }
        else{
            if(paran.isEmpty()){
                return false;
            }
            char t=paran.pop();
            if(samePair(t)!=samePair(c)){
                return false;
            }
        }
      }
      if(paran.size()==0){
        return true;
      }
      return false;
    }
}