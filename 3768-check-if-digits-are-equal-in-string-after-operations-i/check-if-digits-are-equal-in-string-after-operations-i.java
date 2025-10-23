class Solution {
    public boolean hasSameDigits(String s) {
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1)){
                return true;
            }else{
                return false;
            }
        }
        StringBuffer temp=new StringBuffer();
        for(int i=0;i<s.length()-1;i++){
            int a=s.charAt(i)-'0';
            int b=s.charAt(i+1)-'0';
            int c=(a+b)%10;
            temp.append(c+"");
        }
        return hasSameDigits(temp.toString());
    }
}