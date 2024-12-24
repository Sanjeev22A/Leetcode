class Solution {
    public boolean isDigit(char c){
        return c>='0'&& c<='9';
    }
    public String decodeString(String s) {
        Stack<Integer> count=new Stack<>();
        Stack<StringBuilder> strings=new Stack<>();
        StringBuilder current=new StringBuilder();
        int currentNum=0;
        for(char c:s.toCharArray()){
            if(isDigit(c)){
                currentNum=currentNum*10+(c-'0');
            }
            else if(c=='['){
                strings.push(current);
                count.push(currentNum);
                current=new StringBuilder();
                currentNum=0;
            }
            else if(c==']'){
                StringBuilder previous=strings.pop();
                int rep=count.pop();
                for(int i=0;i<rep;i++){
                    previous.append(current);
                }
                current=previous;
                currentNum=0;
            }
            else{
                current.append(c);
                currentNum=0;
            }
        }
        return current.toString();
    }
}