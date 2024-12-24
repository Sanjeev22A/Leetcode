class Solution {
    public String removeStars(String s) {
        StringBuilder result=new StringBuilder();
        Stack<Character> res=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='*'){
                if(!res.isEmpty()){
                    res.pop();
                }
            }
            else{
                res.push(c);
            }
        }
        for(char c:res){
            result.append(c);
        }
        return result.toString();

    }
}