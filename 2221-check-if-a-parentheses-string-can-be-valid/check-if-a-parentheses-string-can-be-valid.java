class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2==1){
            return false;
        }
        Stack<Integer> open=new Stack<>();
        Stack<Integer> unlocked=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' && locked.charAt(i)=='1'){
                open.push(i);
            }
            else if(locked.charAt(i)=='0'){
                unlocked.push(i);
            }
            else{
                if(!open.isEmpty()){
                    open.pop();
                }
                else if(!unlocked.isEmpty()){
                    unlocked.pop();
                }
                else{
                    return false;
                }
            }
        }

        while(!open.isEmpty()){
            if(!unlocked.isEmpty() && open.peek()<unlocked.peek()){
                open.pop();
                unlocked.pop();
            }
            else{
                return false;
            }
        }
        return true;
    }
}