class Solution {
    HashMap<String,List<Integer>> store=new HashMap<>();
    List<Integer> soln(String expression){
        if(store.containsKey(expression)){
            return store.get(expression);
        }
        List<Integer> soln=new ArrayList<>();
        for(int i=0;i<expression.length();i++){
            char c=expression.charAt(i);
            if(c=='-' || c=='+' || c=='*'){
                String left=expression.substring(0,i);
                String right=expression.substring(i+1,expression.length());
                List<Integer> leftAns=soln(left);
                List<Integer> rightAns=soln(right);
                for(int a:leftAns){
                    for(int b:rightAns){
                        if(c=='-'){
                            soln.add(a-b);
                        }
                        else if(c=='+'){
                            soln.add(a+b);
                        }
                        else{
                            soln.add(a*b);
                        }
                    }
                }
            }
        }
        if(soln.isEmpty()){
            soln.add(Integer.parseInt(expression));
        }
        store.put(expression,soln);
        return soln;
    }
    public List<Integer> diffWaysToCompute(String expression) {
        return soln(expression);
    }
}