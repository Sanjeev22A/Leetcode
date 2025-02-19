class Solution {
    char arr[]={'a','b','c'};
    List<String> happy=new ArrayList<>();
    void happy(String current,int n){
        if(current.length()==n){happy.add(current);}
        else if(current.length()==0){
            for(char a:arr){
                String newcur=current+a;
                happy(new String(newcur),n);
                
            }

        }
        else{
            
            for(char a:arr){
                if(a!=current.charAt(current.length()-1)){
                    String newcur=current+a;
                    happy(new String(newcur),n);
                }
            }
        }
    }
    public String getHappyString(int n, int k) {
        happy("",n);
        Collections.sort(happy);
        if(happy.size()<k){return "";}
        return happy.get(k-1);
    }
}