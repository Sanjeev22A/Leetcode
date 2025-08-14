class Solution {
    public String largestGoodInteger(String num) {
        String[] ans=new String[]{"999","888","777","666","555","444","333","222","111","000"};
        for(String a:ans){
            if(num.indexOf(a)!=-1){
                return a;
            }
        }
        return "";
    }
}