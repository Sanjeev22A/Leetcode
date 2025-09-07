class Solution {
    public String maximumNumber(String num, int[] change) {
        String max="0";
        StringBuilder res=new StringBuilder();
        boolean flag=false;
        boolean changed=false;
        for(int i=0;i<num.length();i++){
            //System.out.println(flag+":"+changed);
            if(!flag){
                if(num.charAt(i)-'0'<change[num.charAt(i)-'0']){
                    res.append(""+change[num.charAt(i)-'0']);
                    changed=true;
                }else if(num.charAt(i)-'0'==change[num.charAt(i)-'0']){
                    res.append(num.charAt(i));
                }
                else if(changed){
                    flag=true;
                    res.append(num.charAt(i));
                }else{
                    res.append(num.charAt(i));
                }
            }else{
                res.append(num.charAt(i));
            
                flag=true;
            }
        }
        return res.toString();
    }
}