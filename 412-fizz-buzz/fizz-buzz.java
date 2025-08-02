class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res=new ArrayList<>();
        for(int i=1;i<=n;i++){
            String result="";
            if((i%3!=0) && (i%5!=0)){
                result+=i;
            }else{
                if(i%3==0){
                    result+="Fizz";
                }if(i%5==0){
                    result+="Buzz";
                }
            }
            res.add(result);
        }
        return res;
    
    }
}