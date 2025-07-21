class Solution {
    public String makeFancyString(String s) {
        int count=1;
        StringBuilder res=new StringBuilder();
        char prev='.';
        for(char c:s.toCharArray()){
            if(c!=prev){
                count=1;
                res.append(c);
                prev=c;
            }else{
                count++;
                if(count<3){
                    res.append(c);
                }
            }
        }
        return res.toString();
    }
}