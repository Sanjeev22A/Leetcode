class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int a:asteroids){
            boolean dest=false;
            
            while(!stack.isEmpty() && !dest && a<0){
                    
                    int top=stack.peek();
                    if(a*top>0){
                        break;
                        
                    }
                    if(Math.abs(top)==Math.abs(a)){
                        stack.pop();
                        dest=true;
                    }
                    else if(Math.abs(top)>Math.abs(a)){
                        dest=true;
                    }
                    else{
                        stack.pop();
                    }
                }
                if(!dest){
                    stack.push(a);
                }
        }
        
        int[] res=new int[stack.size()];
        for(int i=0;i<stack.size();i++){
            res[i]=stack.get(i);
        }
        return res;
    }
}